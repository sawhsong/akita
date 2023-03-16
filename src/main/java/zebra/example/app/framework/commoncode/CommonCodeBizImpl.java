package zebra.example.app.framework.commoncode;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import zebra.data.DataSet;
import zebra.data.ParamEntity;
import zebra.data.QueryAdvisor;
import zebra.example.common.extend.BaseBiz;
import zebra.example.common.module.commoncode.ZebraCommonCodeManager;
import zebra.example.conf.resource.ormapper.dao.ZebraCommonCode.ZebraCommonCodeDao;
import zebra.example.conf.resource.ormapper.dto.oracle.ZebraCommonCode;
import zebra.exception.FrameworkException;
import zebra.export.ExportHelper;
import zebra.util.CommonUtil;
import zebra.util.ConfigUtil;
import zebra.util.ExportUtil;

public class CommonCodeBizImpl extends BaseBiz implements CommonCodeBiz {
	@Autowired
	private ZebraCommonCodeDao zebraCommonCodeDao;

	public ParamEntity getDefault(ParamEntity paramEntity) throws Exception {
		try {
			paramEntity.setSuccess(true);
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}

		return paramEntity;
	}

	public ParamEntity getList(ParamEntity paramEntity) throws Exception {
		DataSet requestDataSet = paramEntity.getRequestDataSet();
		QueryAdvisor queryAdvisor = paramEntity.getQueryAdvisor();
		String codeType = requestDataSet.getValue("commonCodeType");

		try {
			queryAdvisor.setPagination(true);
			queryAdvisor.addAutoFillCriteria(codeType, "code_type = '"+codeType+"'");

			paramEntity.setAjaxResponseDataSet(zebraCommonCodeDao.getActiveCommonCodeDataSet(queryAdvisor));
			paramEntity.setTotalResultRows(queryAdvisor.getTotalResultRows());
			paramEntity.setSuccess(true);
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}

		return paramEntity;
	}

	public ParamEntity getEdit(ParamEntity paramEntity) throws Exception {
		try {
			paramEntity.setSuccess(true);
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}

		return paramEntity;
	}

	public ParamEntity getMasterData(ParamEntity paramEntity) throws Exception {
		DataSet requestDataSet = paramEntity.getRequestDataSet();

		try {
			paramEntity.setAjaxResponseDataSet(zebraCommonCodeDao.getCommonCodeDataSetByCodeType(requestDataSet.getValue("codeType")));
			paramEntity.setSuccess(true);
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}

		return paramEntity;
	}

	public ParamEntity getDetailData(ParamEntity paramEntity) throws Exception {
		DataSet requestDataSet = paramEntity.getRequestDataSet();

		try {
			paramEntity.setAjaxResponseDataSet(zebraCommonCodeDao.getCommonCodeDataSetByCodeType(requestDataSet.getValue("codeType")));
			paramEntity.setSuccess(true);
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}

		return paramEntity;
	}

	public ParamEntity doSave(ParamEntity paramEntity) throws Exception {
		DataSet requestDataSet = paramEntity.getRequestDataSet();
		ZebraCommonCode zebraCommonCode = new ZebraCommonCode();
		HttpSession session = paramEntity.getSession();
		String delimiter = ConfigUtil.getProperty("delimiter.data");
		String codeType = CommonUtil.upperCase(requestDataSet.getValue("codeTypeMaster"));
		int detailLength = CommonUtil.toInt(requestDataSet.getValue("detailLength"));
		DataSet detailDataSet;
		int result = -1, masterDataRow = -1;

		try {
			detailDataSet = zebraCommonCodeDao.getCommonCodeDataSetByCodeType(codeType);

			if (detailDataSet.getRowCnt() <= 0) {
				zebraCommonCode.setIsDefault(ZebraCommonCodeManager.getCodeByConstants("SIMPLE_YN_N"));
				zebraCommonCode.setInsertUserId((String)session.getAttribute("UserId"));
				zebraCommonCode.setInsertDate(CommonUtil.toDate(CommonUtil.getSysdate()));
			} else {
				masterDataRow = detailDataSet.getRowIndex("COMMON_CODE", "0000000000");

				result = zebraCommonCodeDao.delete(codeType);
				if (result <= 0) {
					throw new FrameworkException("E801", getMessage("E801", paramEntity));
				}

				zebraCommonCode.setIsDefault(detailDataSet.getValue(masterDataRow, "IS_DEFAULT"));
				zebraCommonCode.setInsertUserId(detailDataSet.getValue(masterDataRow, "INSERT_USER_ID"));
				zebraCommonCode.setInsertDate(CommonUtil.toDate(detailDataSet.getValue(masterDataRow, "INSERT_DATE")));
				zebraCommonCode.setUpdateUserId((String)session.getAttribute("UserId"));
				zebraCommonCode.setUpdateDate(CommonUtil.toDate(CommonUtil.getSysdate()));
			}

			zebraCommonCode.setCodeType(codeType);
			zebraCommonCode.setCommonCode("0000000000");
			zebraCommonCode.setCodeMeaning(requestDataSet.getValue("codeMeaningMaster"));
			zebraCommonCode.setDescriptionEn(requestDataSet.getValue("descriptionMaster"));
			zebraCommonCode.setDescriptionKo(requestDataSet.getValue("descriptionMaster"));
			zebraCommonCode.setProgramConstants(codeType + "_0000000000");
			zebraCommonCode.setSortOrder("000");
			zebraCommonCode.setIsActive(CommonUtil.nvl(requestDataSet.getValue("isActiveMaster"), "N"));

			result = zebraCommonCodeDao.insert(zebraCommonCode);
			if (result <= 0) {
				throw new FrameworkException("E801", getMessage("E801", paramEntity));
			}

			result = 0;
			for (int i=0; i<detailLength; i++) {
				String commonCode = requestDataSet.getValue("commonCodeDetail" + delimiter + i);

				zebraCommonCode.setCommonCode(commonCode);
				zebraCommonCode.setCodeMeaning(requestDataSet.getValue("codeMeaningDetail" + delimiter + i));
				zebraCommonCode.setDescriptionEn(requestDataSet.getValue("descriptionDetail" + delimiter + i));
				zebraCommonCode.setDescriptionKo(requestDataSet.getValue("descriptionDetail" + delimiter + i));
				zebraCommonCode.setProgramConstants(codeType + "_" + CommonUtil.upperCase(commonCode));
				zebraCommonCode.setSortOrder(requestDataSet.getValue("sortOrderDetail" + delimiter + i));
				zebraCommonCode.setIsActive(CommonUtil.nvl(requestDataSet.getValue("isActiveDetail" + delimiter + i), "N"));
				zebraCommonCode.setIsDefault(detailDataSet.getValue(masterDataRow, "IS_DEFAULT"));

				result += zebraCommonCodeDao.insert(zebraCommonCode);
			}

			if (result != detailLength) {
				throw new FrameworkException("E801", getMessage("E801", paramEntity));
			}

			paramEntity.setSuccess(true);
			paramEntity.setMessage("I801", getMessage("I801", paramEntity));
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}

		return paramEntity;
	}

	public ParamEntity doDelete(ParamEntity paramEntity) throws Exception {
		DataSet requestDataSet = paramEntity.getRequestDataSet();
		String codeType = requestDataSet.getValue("codeType");
		String chkForDel = requestDataSet.getValue("chkForDel");
		String[] codeTypes = CommonUtil.splitWithTrim(chkForDel, ConfigUtil.getProperty("delimiter.record"));
		int result = -1;

		try {
			if (CommonUtil.isBlank(codeType)) {
				result = zebraCommonCodeDao.delete(codeTypes);
			} else {
				result = zebraCommonCodeDao.delete(codeType);
			}

			if (result <= 0) {
				throw new FrameworkException("E801", getMessage("E801", paramEntity));
			}

			paramEntity.setSuccess(true);
			paramEntity.setMessage("I801", getMessage("I801", paramEntity));
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}

		return paramEntity;
	}

	public ParamEntity doExport(ParamEntity paramEntity) throws Exception {
		DataSet requestDataSet = paramEntity.getRequestDataSet();
		QueryAdvisor queryAdvisor = paramEntity.getQueryAdvisor();
		ExportHelper exportHelper;
		String dataRange = requestDataSet.getValue("dataRange");
		String codeType = requestDataSet.getValue("commonCodeType");

		try {
			String pageTitle = "Common Code List";
			String fileName = "CommonCodeList";
			String[] columnHeader = {"code_type", "common_code", "code_meaning", "program_constants", "description_en", "description_ko", "sort_order", "is_active", "is_default"};
			String[] fileHeader = {"CODE TYPE", "COMMON CODE", "CODE MEANING", "PROGRAM CONSTANTS", "DESCRIPTION(EN)", "DESCRIPTION(KO)", "SORT ORDER", "IS ACTIVE", "IS DEFAULT"};

			exportHelper = ExportUtil.getExportHelper(requestDataSet.getValue("fileType"));
			exportHelper.setPageTitle(pageTitle);
			exportHelper.setColumnHeader(columnHeader);
			exportHelper.setFileHeader(fileHeader);
			exportHelper.setFileName(fileName);
			exportHelper.setPdfWidth(1000);

			queryAdvisor.addAutoFillCriteria(codeType, "code_type = '"+codeType+"'");
			if (CommonUtil.containsIgnoreCase(dataRange, "all"))
				queryAdvisor.setPagination(false);
			else {
				queryAdvisor.setPagination(true);
			}

			exportHelper.setSourceDataSet(zebraCommonCodeDao.getActiveCommonCodeDataSet(queryAdvisor));

			paramEntity.setSuccess(true);
			paramEntity.setFileToExport(exportHelper.createFile());
			paramEntity.setFileNameToExport(exportHelper.getFileName());
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}

		return paramEntity;
	}
}