package zebra.example.app.framework.sourcegenerator;

import org.springframework.beans.factory.annotation.Autowired;

import project.conf.resource.ormapper.dao.SysMenu.SysMenuDao;
import zebra.config.MemoryBean;
import zebra.data.DataSet;
import zebra.data.ParamEntity;
import zebra.data.QueryAdvisor;
import zebra.example.common.bizservice.framework.ZebraFrameworkBizService;
import zebra.example.common.extend.BaseBiz;
import zebra.exception.FrameworkException;
import zebra.util.BeanHelper;
import zebra.util.CommonUtil;
import zebra.util.ConfigUtil;
import zebra.util.FileUtil;

public class SourceGeneratorBizImpl extends BaseBiz implements SourceGeneratorBiz {
	@Autowired
	private SysMenuDao sysMenuDao;
	@Autowired
	private ZebraFrameworkBizService zebraFramworkBizService;

	public ParamEntity getDefault(ParamEntity paramEntity) throws Exception {
		QueryAdvisor qaMenu = paramEntity.getQueryAdvisor();
		String dateFormat = ConfigUtil.getProperty("format.date.java");

		try {
			qaMenu.addVariable("dateFormat", dateFormat);
			qaMenu.addAutoFillCriteria("searchMenu", "menu_level = '1'");
			qaMenu.setPagination(false);

			paramEntity.setObject("searchMenu", sysMenuDao.getAllActiveMenuDataSetBySearchCriteria(qaMenu));
			paramEntity.setSuccess(true);
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}

		return paramEntity;
	}

	public ParamEntity getList(ParamEntity paramEntity) throws Exception {
		DataSet requestDataSet = paramEntity.getRequestDataSet();
		DataSet resultDataSet = new DataSet();
		QueryAdvisor qaList = paramEntity.getQueryAdvisor();
		String dateFormat = ConfigUtil.getProperty("format.date.java");
		String searchMenu = requestDataSet.getValue("searchMenu");

		try {
			qaList.addVariable("dateFormat", dateFormat);
			qaList.addAutoFillCriteria(searchMenu, "root = '"+searchMenu+"'");
			qaList.setPagination(false);

			resultDataSet = sysMenuDao.getAllActiveMenuDataSetBySearchCriteria(qaList);
			resultDataSet.addColumn("IS_EDITABLE");
			for (int i=0; i<resultDataSet.getRowCnt(); i++) {
				if (CommonUtil.equals(resultDataSet.getValue(i, "IS_LEAF"), "1")) {
					if (!(BeanHelper.containsBean(CommonUtil.toCamelCaseStartLowerCase(resultDataSet.getValue(i, "MENU_ID"))+"Action") || 
							BeanHelper.containsBean(CommonUtil.toStartLowerCase(resultDataSet.getValue(i, "MENU_ID"))+"Action"))) {
						resultDataSet.setValue(i, "IS_EDITABLE", "true");
					}
				}
			}

			paramEntity.setAjaxResponseDataSet(resultDataSet);
			paramEntity.setTotalResultRows(qaList.getTotalResultRows());
			paramEntity.setSuccess(true);
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}

		return paramEntity;
	}

	public ParamEntity getGeneratorInfo(ParamEntity paramEntity) throws Exception {
		String compilePath = "/target/alpaca";
		String rootPath = CommonUtil.remove((String)MemoryBean.get("applicationRealPath"), compilePath);
		String javaPath = ConfigUtil.getProperty("path.java.app");
		String jspPath = ConfigUtil.getProperty("path.web.app");
		String springPath = ConfigUtil.getProperty("path.conf.menuSpring");
		String strutsPath = ConfigUtil.getProperty("path.conf.menuStruts");
		String messagePath = ConfigUtil.getProperty("path.resource.menuMessage");

		try {
			paramEntity.setObject("javaPath", rootPath + javaPath);
			paramEntity.setObject("jspPath", rootPath + jspPath);
			paramEntity.setObject("springPath", rootPath + springPath);
			paramEntity.setObject("strutsPath", rootPath + strutsPath);
			paramEntity.setObject("messagePath", rootPath + messagePath);

			paramEntity.setSuccess(true);
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}
		return paramEntity;
	}

	public ParamEntity exeGenerateN(ParamEntity paramEntity) throws Exception {
		DataSet requestDataSet = paramEntity.getRequestDataSet();
		String[] menuPaths = CommonUtil.split(CommonUtil.replace(requestDataSet.getValue("menuId"), ConfigUtil.getProperty("delimiter.data"), "/"), "/");
		String menuPathStr = CommonUtil.lowerCase(menuPaths[0])+"/"+menuPaths[1]+"/"+menuPaths[2];
		String javaPath = requestDataSet.getValue("javaSourcePath");
		String jspPath = requestDataSet.getValue("jspSourcePath");
		String springPath = requestDataSet.getValue("springConfigPath");
		String strutsPath = requestDataSet.getValue("strutsConfigPath");
		String messagePath = requestDataSet.getValue("messageConfigPath");
		boolean isCreateSpring = CommonUtil.toBoolean(CommonUtil.nvl(requestDataSet.getValue("createSpring"), "N"));
		boolean isCreateStruts = CommonUtil.toBoolean(CommonUtil.nvl(requestDataSet.getValue("createStruts"), "N"));
		boolean isCreateMessage = CommonUtil.toBoolean(CommonUtil.nvl(requestDataSet.getValue("createMessage"), "N"));

		try {
			FileUtil.createFolder(javaPath+"/"+menuPathStr);
			FileUtil.createFolder(jspPath+"/"+menuPathStr);
			FileUtil.createFolder(jspPath+"js/"+menuPathStr);

			if (isCreateSpring) {
				FileUtil.createFolder(springPath);
			}

			if (isCreateStruts) {
				FileUtil.createFolder(strutsPath);
			}

			if (isCreateMessage) {
				FileUtil.createFolder(messagePath+"/"+menuPathStr);
			}

			zebraFramworkBizService.createJavaActionN(requestDataSet);
			zebraFramworkBizService.createJavaBizN(requestDataSet);
			zebraFramworkBizService.createJavaBizImplN(requestDataSet);

			zebraFramworkBizService.createJspListN(requestDataSet);
			zebraFramworkBizService.createJspDetailN(requestDataSet);
			zebraFramworkBizService.createJspEditN(requestDataSet);
			zebraFramworkBizService.createJspInsertN(requestDataSet);
			zebraFramworkBizService.createJspUpdateN(requestDataSet);

			zebraFramworkBizService.createConfSpringN(requestDataSet);
			zebraFramworkBizService.createConfStrutsN(requestDataSet);
			zebraFramworkBizService.createMessageFileN(requestDataSet);

			paramEntity.setSuccess(true);
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}

		return paramEntity;
	}

	public ParamEntity exeGenerateC(ParamEntity paramEntity) throws Exception {
		DataSet requestDataSet = paramEntity.getRequestDataSet();
		String menuPathStr = CommonUtil.lowerCase(CommonUtil.replace(requestDataSet.getValue("menuId"), ConfigUtil.getProperty("delimiter.data"), "/"));
		String javaPath = requestDataSet.getValue("javaSourcePath");
		String jspPath = requestDataSet.getValue("jspSourcePath");
		String springPath = requestDataSet.getValue("springConfigPath");
		String strutsPath = requestDataSet.getValue("strutsConfigPath");
		String messagePath = requestDataSet.getValue("messageConfigPath");
		boolean isCreateSpring = CommonUtil.toBoolean(CommonUtil.nvl(requestDataSet.getValue("createSpring"), "N"));
		boolean isCreateStruts = CommonUtil.toBoolean(CommonUtil.nvl(requestDataSet.getValue("createStruts"), "N"));
		boolean isCreateMessage = CommonUtil.toBoolean(CommonUtil.nvl(requestDataSet.getValue("createMessage"), "N"));

		try {
			FileUtil.createFolder(javaPath+"/"+menuPathStr);
			FileUtil.createFolder(jspPath+"/"+menuPathStr);
			FileUtil.createFolder(jspPath+"js/"+menuPathStr);

			if (isCreateSpring) {
				FileUtil.createFolder(springPath);
			}

			if (isCreateStruts) {
				FileUtil.createFolder(strutsPath);
			}

			if (isCreateMessage) {
				FileUtil.createFolder(messagePath+"/"+menuPathStr);
			}

			zebraFramworkBizService.createJavaActionC(requestDataSet);
			zebraFramworkBizService.createJavaBizC(requestDataSet);
			zebraFramworkBizService.createJavaBizImplC(requestDataSet);

			zebraFramworkBizService.createJspListC(requestDataSet);
			zebraFramworkBizService.createJspDetailC(requestDataSet);
			zebraFramworkBizService.createJspEditC(requestDataSet);
			zebraFramworkBizService.createJspInsertC(requestDataSet);
			zebraFramworkBizService.createJspUpdateC(requestDataSet);

			zebraFramworkBizService.createConfSpringC(requestDataSet);
			zebraFramworkBizService.createConfStrutsC(requestDataSet);
			zebraFramworkBizService.createMessageFileC(requestDataSet);

			paramEntity.setSuccess(true);
		} catch (Exception ex) {
			throw new FrameworkException(paramEntity, ex);
		}

		return paramEntity;
	}
}