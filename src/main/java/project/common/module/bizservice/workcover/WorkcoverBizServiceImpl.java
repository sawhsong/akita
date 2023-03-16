package project.common.module.bizservice.workcover;

import org.springframework.beans.factory.annotation.Autowired;

import project.common.module.commoncode.CommonCodeManager;
import project.conf.resource.ormapper.dao.HpOrganisationD.HpOrganisationDDao;
import project.conf.resource.ormapper.dao.WcActCodeRate.WcActCodeRateDao;
import project.conf.resource.ormapper.dao.WcActCodeRateD.WcActCodeRateDDao;
import project.conf.resource.ormapper.dao.WcActOrgCodeRateLink.WcActOrgCodeRateLinkDao;
import project.conf.resource.ormapper.dao.WcNswCodeRate.WcNswCodeRateDao;
import project.conf.resource.ormapper.dao.WcNswCodeRateD.WcNswCodeRateDDao;
import project.conf.resource.ormapper.dao.WcNswOrgCodeRateLink.WcNswOrgCodeRateLinkDao;
import project.conf.resource.ormapper.dao.WcNtCodeRate.WcNtCodeRateDao;
import project.conf.resource.ormapper.dao.WcNtCodeRateD.WcNtCodeRateDDao;
import project.conf.resource.ormapper.dao.WcNtOrgCodeRateLink.WcNtOrgCodeRateLinkDao;
import project.conf.resource.ormapper.dao.WcQldCodeRate.WcQldCodeRateDao;
import project.conf.resource.ormapper.dao.WcQldCodeRateD.WcQldCodeRateDDao;
import project.conf.resource.ormapper.dao.WcQldOrgCodeRateLink.WcQldOrgCodeRateLinkDao;
import project.conf.resource.ormapper.dao.WcSaIndustryRate.WcSaIndustryRateDao;
import project.conf.resource.ormapper.dao.WcSaIndustryRateD.WcSaIndustryRateDDao;
import project.conf.resource.ormapper.dao.WcSaOrgCodeRateLink.WcSaOrgCodeRateLinkDao;
import project.conf.resource.ormapper.dao.WcTasCodeRate.WcTasCodeRateDao;
import project.conf.resource.ormapper.dao.WcTasCodeRateD.WcTasCodeRateDDao;
import project.conf.resource.ormapper.dao.WcTasOrgCodeRateLink.WcTasOrgCodeRateLinkDao;
import project.conf.resource.ormapper.dao.WcVicIndustryRate.WcVicIndustryRateDao;
import project.conf.resource.ormapper.dao.WcVicIndustryRateD.WcVicIndustryRateDDao;
import project.conf.resource.ormapper.dao.WcVicOrgCodeRateLink.WcVicOrgCodeRateLinkDao;
import project.conf.resource.ormapper.dao.WcWaCodeRate.WcWaCodeRateDao;
import project.conf.resource.ormapper.dao.WcWaCodeRateD.WcWaCodeRateDDao;
import project.conf.resource.ormapper.dao.WcWaOrgCodeRateLink.WcWaOrgCodeRateLinkDao;
import project.conf.resource.ormapper.dto.oracle.HpOrganisationD;
import project.conf.resource.ormapper.dto.oracle.WcActCodeRate;
import project.conf.resource.ormapper.dto.oracle.WcActCodeRateD;
import project.conf.resource.ormapper.dto.oracle.WcActOrgCodeRateLink;
import project.conf.resource.ormapper.dto.oracle.WcNswCodeRate;
import project.conf.resource.ormapper.dto.oracle.WcNswCodeRateD;
import project.conf.resource.ormapper.dto.oracle.WcNswOrgCodeRateLink;
import project.conf.resource.ormapper.dto.oracle.WcNtCodeRate;
import project.conf.resource.ormapper.dto.oracle.WcNtCodeRateD;
import project.conf.resource.ormapper.dto.oracle.WcNtOrgCodeRateLink;
import project.conf.resource.ormapper.dto.oracle.WcQldCodeRate;
import project.conf.resource.ormapper.dto.oracle.WcQldCodeRateD;
import project.conf.resource.ormapper.dto.oracle.WcQldOrgCodeRateLink;
import project.conf.resource.ormapper.dto.oracle.WcSaIndustryRate;
import project.conf.resource.ormapper.dto.oracle.WcSaIndustryRateD;
import project.conf.resource.ormapper.dto.oracle.WcSaOrgCodeRateLink;
import project.conf.resource.ormapper.dto.oracle.WcTasCodeRate;
import project.conf.resource.ormapper.dto.oracle.WcTasCodeRateD;
import project.conf.resource.ormapper.dto.oracle.WcTasOrgCodeRateLink;
import project.conf.resource.ormapper.dto.oracle.WcVicIndustryRate;
import project.conf.resource.ormapper.dto.oracle.WcVicIndustryRateD;
import project.conf.resource.ormapper.dto.oracle.WcVicOrgCodeRateLink;
import project.conf.resource.ormapper.dto.oracle.WcWaCodeRate;
import project.conf.resource.ormapper.dto.oracle.WcWaCodeRateD;
import project.conf.resource.ormapper.dto.oracle.WcWaOrgCodeRateLink;
import zebra.data.QueryAdvisor;
import zebra.example.common.extend.BaseBiz;
import zebra.util.CommonUtil;
import zebra.util.ConfigUtil;

public class WorkcoverBizServiceImpl extends BaseBiz implements WorkcoverBizService {
	@Autowired
	private HpOrganisationDDao hpOrganisationDDao;
	@Autowired
	private WcActOrgCodeRateLinkDao wcActOrgCodeRateLinkDao;
	@Autowired
	private WcActCodeRateDao wcActCodeRateDao;
	@Autowired
	private WcActCodeRateDDao wcActCodeRateDDao;
	@Autowired
	private WcNswOrgCodeRateLinkDao wcNswOrgCodeRateLinkDao;
	@Autowired
	private WcNswCodeRateDao wcNswCodeRateDao;
	@Autowired
	private WcNswCodeRateDDao wcNswCodeRateDDao;
	@Autowired
	private WcNtOrgCodeRateLinkDao wcNtOrgCodeRateLinkDao;
	@Autowired
	private WcNtCodeRateDao wcNtCodeRateDao;
	@Autowired
	private WcNtCodeRateDDao wcNtCodeRateDDao;
	@Autowired
	private WcQldOrgCodeRateLinkDao wcQldOrgCodeRateLinkDao;
	@Autowired
	private WcQldCodeRateDao wcQldCodeRateDao;
	@Autowired
	private WcQldCodeRateDDao wcQldCodeRateDDao;
	@Autowired
	private WcSaOrgCodeRateLinkDao wcSaOrgCodeRateLinkDao;
	@Autowired
	private WcSaIndustryRateDao wcSaIndustryRateDao;
	@Autowired
	private WcSaIndustryRateDDao wcSaIndustryRateDDao;
	@Autowired
	private WcTasOrgCodeRateLinkDao wcTasOrgCodeRateLinkDao;
	@Autowired
	private WcTasCodeRateDao wcTasCodeRateDao;
	@Autowired
	private WcTasCodeRateDDao wcTasCodeRateDDao;
	@Autowired
	private WcVicOrgCodeRateLinkDao wcVicOrgCodeRateLinkDao;
	@Autowired
	private WcVicIndustryRateDao wcVicIndustryRateDao;
	@Autowired
	private WcVicIndustryRateDDao wcVicIndustryRateDDao;
	@Autowired
	private WcWaOrgCodeRateLinkDao wcWaOrgCodeRateLinkDao;
	@Autowired
	private WcWaCodeRateDao wcWaCodeRateDao;
	@Autowired
	private WcWaCodeRateDDao wcWaCodeRateDDao;

	public String getWcCodeRateId(QueryAdvisor queryAdvisor) throws Exception {
		queryAdvisor.setObject("variableName", "wcCodeRateId");
		return getWorkcoverVariable(queryAdvisor);
	}

	public String getWcCodeRateName(QueryAdvisor queryAdvisor) throws Exception {
		queryAdvisor.setObject("variableName", "wcCodeRateName");
		return getWorkcoverVariable(queryAdvisor);
	}

	public String getWcWicAnzic(QueryAdvisor queryAdvisor) throws Exception {
		queryAdvisor.setObject("variableName", "wcWicAnzic");
		return getWorkcoverVariable(queryAdvisor);
	}

	public double getWcPercentage(QueryAdvisor queryAdvisor) throws Exception {
		queryAdvisor.setObject("variableName", "wcPercentage");
		return CommonUtil.toDouble(getWorkcoverVariable(queryAdvisor));
	}

	public String getWcStartDate(QueryAdvisor queryAdvisor) throws Exception {
		queryAdvisor.setObject("variableName", "wcStartDate");
		return getWorkcoverVariable(queryAdvisor);
	}

	public String getWcEndDate(QueryAdvisor queryAdvisor) throws Exception {
		queryAdvisor.setObject("variableName", "wcEndDate");
		return getWorkcoverVariable(queryAdvisor);
	}

	public String getWorkingState(QueryAdvisor queryAdvisor) throws Exception {
		queryAdvisor.setObject("variableName", "wcWorkingState");
		return getWorkcoverVariable(queryAdvisor);
	}

	public String getWorkingStateMeaning(QueryAdvisor queryAdvisor) throws Exception {
		queryAdvisor.setObject("variableName", "wcWorkingStateMeaning");
		return getWorkcoverVariable(queryAdvisor);
	}

	private String getWorkcoverVariable(QueryAdvisor queryAdvisor) throws Exception {
		String dataSource = (String)queryAdvisor.getObject("dataSource");
		String orgId = (String)queryAdvisor.getObject("organisationId");
		String linkId = (String)queryAdvisor.getObject("wcOrgCodeRateLinkId");
		String variableName = (String)queryAdvisor.getObject("variableName");
		String workingState = (String)queryAdvisor.getObject("workingState");
		String stateCode = "", rtnString = "", dateFormat = ConfigUtil.getProperty("format.date.java");
		HpOrganisationD hpOrganisationD;

		if (!(CommonUtil.isValidId(orgId) && CommonUtil.isValidId(linkId))) {
			return "";
		}

		hpOrganisationDDao.setDataSourceName(dataSource);
		hpOrganisationD = hpOrganisationDDao.getOrganisationByOrganisationId(orgId);
		if (CommonUtil.isBlank(workingState)) {
			workingState = hpOrganisationD.getState();
			stateCode = CommonUtil.getStateCode(workingState);
		} else {
			stateCode = CommonUtil.getStateCode(workingState);
		}

		if (CommonUtil.equalsIgnoreCase(stateCode, "ACT")) {
			wcActOrgCodeRateLinkDao.setDataSourceName(dataSource);
			wcActCodeRateDao.setDataSourceName(dataSource);
			wcActCodeRateDDao.setDataSourceName(dataSource);
			WcActOrgCodeRateLink orgCodeRateLink = wcActOrgCodeRateLinkDao.getWcActOrgCodeRateLinkById(linkId);
			WcActCodeRate codeRate = wcActCodeRateDao.getWcActCodeRateById(CommonUtil.toStringForId(orgCodeRateLink.getCodeRateId()));
			WcActCodeRateD codeRateD = wcActCodeRateDDao.getWcActCodeRateDByWcActCodeRateId(CommonUtil.toStringForId(orgCodeRateLink.getCodeRateId()));

			if (CommonUtil.equals(variableName, "wcCodeRateId")) {
				rtnString = CommonUtil.toStringForId(orgCodeRateLink.getCodeRateId());
			} else if (CommonUtil.equals(variableName, "wcCodeRateName")) {
				rtnString = codeRate.getCodeName();
			} else if (CommonUtil.equals(variableName, "wcWicAnzic")) {
				rtnString = codeRate.getAnzic();
			} else if (CommonUtil.equals(variableName, "wcPercentage")) {
				rtnString = CommonUtil.toStringWithNoFormat(codeRateD.getPercentage());
			} else if (CommonUtil.equals(variableName, "wcStartDate")) {
				rtnString = CommonUtil.toString(codeRateD.getStartDate(), dateFormat);
			} else if (CommonUtil.equals(variableName, "wcEndDate")) {
				rtnString = CommonUtil.toString(codeRateD.getEndDate(), dateFormat);
			} else if (CommonUtil.equals(variableName, "wcWorkingState")) {
				rtnString = workingState;
			} else if (CommonUtil.equals(variableName, "wcWorkingStateMeaning")) {
				rtnString = CommonCodeManager.getCodeMeaning("STATES", workingState);
			}
		} else if (CommonUtil.equalsIgnoreCase(stateCode, "NSW")) {
			wcNswOrgCodeRateLinkDao.setDataSourceName(dataSource);
			wcNswCodeRateDao.setDataSourceName(dataSource);
			wcNswCodeRateDDao.setDataSourceName(dataSource);
			WcNswOrgCodeRateLink orgCodeRateLink = wcNswOrgCodeRateLinkDao.getWcNswOrgCodeRateLinkById(linkId);
			WcNswCodeRate codeRate = wcNswCodeRateDao.getWcNswCodeRateById(CommonUtil.toStringForId(orgCodeRateLink.getCodeRateId()));
			WcNswCodeRateD codeRateD = wcNswCodeRateDDao.getWcNswCodeRateDByWcNswCodeRateId(CommonUtil.toStringForId(orgCodeRateLink.getCodeRateId()));

			if (CommonUtil.equals(variableName, "wcCodeRateId")) {
				rtnString = CommonUtil.toStringForId(orgCodeRateLink.getCodeRateId());
			} else if (CommonUtil.equals(variableName, "wcCodeRateName")) {
				rtnString = codeRate.getCodeName();
			} else if (CommonUtil.equals(variableName, "wcWicAnzic")) {
				rtnString = codeRate.getWic();
			} else if (CommonUtil.equals(variableName, "wcPercentage")) {
				rtnString = CommonUtil.toStringWithNoFormat(codeRateD.getPercentage());
			} else if (CommonUtil.equals(variableName, "wcStartDate")) {
				rtnString = CommonUtil.toString(codeRateD.getStartDate(), dateFormat);
			} else if (CommonUtil.equals(variableName, "wcEndDate")) {
				rtnString = CommonUtil.toString(codeRateD.getEndDate(), dateFormat);
			} else if (CommonUtil.equals(variableName, "wcWorkingState")) {
				rtnString = workingState;
			} else if (CommonUtil.equals(variableName, "wcWorkingStateMeaning")) {
				rtnString = CommonCodeManager.getCodeMeaning("STATES", workingState);
			}
		} else if (CommonUtil.equalsIgnoreCase(stateCode, "NT")) {
			wcNtOrgCodeRateLinkDao.setDataSourceName(dataSource);
			wcNtCodeRateDao.setDataSourceName(dataSource);
			wcNtCodeRateDDao.setDataSourceName(dataSource);
			WcNtOrgCodeRateLink orgCodeRateLink = wcNtOrgCodeRateLinkDao.getWcNtOrgCodeRateLinkById(linkId);
			WcNtCodeRate codeRate = wcNtCodeRateDao.getWcNtCodeRateById(CommonUtil.toStringForId(orgCodeRateLink.getCodeRateId()));
			WcNtCodeRateD codeRateD = wcNtCodeRateDDao.getWcNtCodeRateDByWcNtCodeRateId(CommonUtil.toStringForId(orgCodeRateLink.getCodeRateId()));

			if (CommonUtil.equals(variableName, "wcCodeRateId")) {
				rtnString = CommonUtil.toStringForId(orgCodeRateLink.getCodeRateId());
			} else if (CommonUtil.equals(variableName, "wcCodeRateName")) {
				rtnString = codeRate.getCodeName();
			} else if (CommonUtil.equals(variableName, "wcWicAnzic")) {
				rtnString = codeRate.getAnzic();
			} else if (CommonUtil.equals(variableName, "wcPercentage")) {
				rtnString = CommonUtil.toStringWithNoFormat(codeRateD.getPercentage());
			} else if (CommonUtil.equals(variableName, "wcStartDate")) {
				rtnString = CommonUtil.toString(codeRateD.getStartDate(), dateFormat);
			} else if (CommonUtil.equals(variableName, "wcEndDate")) {
				rtnString = CommonUtil.toString(codeRateD.getEndDate(), dateFormat);
			} else if (CommonUtil.equals(variableName, "wcWorkingState")) {
				rtnString = workingState;
			} else if (CommonUtil.equals(variableName, "wcWorkingStateMeaning")) {
				rtnString = CommonCodeManager.getCodeMeaning("STATES", workingState);
			}
		} else if (CommonUtil.equalsIgnoreCase(stateCode, "QLD")) {
			wcQldOrgCodeRateLinkDao.setDataSourceName(dataSource);
			wcQldCodeRateDao.setDataSourceName(dataSource);
			wcQldCodeRateDDao.setDataSourceName(dataSource);
			WcQldOrgCodeRateLink orgCodeRateLink = wcQldOrgCodeRateLinkDao.getWcQldOrgCodeRateLinkById(linkId);
			WcQldCodeRate codeRate = wcQldCodeRateDao.getWcQldCodeRateById(CommonUtil.toStringForId(orgCodeRateLink.getCodeRateId()));
			WcQldCodeRateD codeRateD = wcQldCodeRateDDao.getWcQldCodeRateDByWcQldCodeRateId(CommonUtil.toStringForId(orgCodeRateLink.getCodeRateId()));

			if (CommonUtil.equals(variableName, "wcCodeRateId")) {
				rtnString = CommonUtil.toStringForId(orgCodeRateLink.getCodeRateId());
			} else if (CommonUtil.equals(variableName, "wcCodeRateName")) {
				rtnString = codeRate.getCodeName();
			} else if (CommonUtil.equals(variableName, "wcWicAnzic")) {
				rtnString = codeRate.getWic();
			} else if (CommonUtil.equals(variableName, "wcPercentage")) {
				rtnString = CommonUtil.toStringWithNoFormat(codeRateD.getPercentage());
			} else if (CommonUtil.equals(variableName, "wcStartDate")) {
				rtnString = CommonUtil.toString(codeRateD.getStartDate(), dateFormat);
			} else if (CommonUtil.equals(variableName, "wcEndDate")) {
				rtnString = CommonUtil.toString(codeRateD.getEndDate(), dateFormat);
			} else if (CommonUtil.equals(variableName, "wcWorkingState")) {
				rtnString = workingState;
			} else if (CommonUtil.equals(variableName, "wcWorkingStateMeaning")) {
				rtnString = CommonCodeManager.getCodeMeaning("STATES", workingState);
			}
		} else if (CommonUtil.equalsIgnoreCase(stateCode, "SA")) {
			wcSaOrgCodeRateLinkDao.setDataSourceName(dataSource);
			wcSaIndustryRateDao.setDataSourceName(dataSource);
			wcSaIndustryRateDDao.setDataSourceName(dataSource);
			WcSaOrgCodeRateLink orgCodeRateLink = wcSaOrgCodeRateLinkDao.getWcSaOrgCodeRateLinkById(linkId);
			WcSaIndustryRate codeRate = wcSaIndustryRateDao.getWcSaIndustryRateById(CommonUtil.toStringForId(orgCodeRateLink.getIndustryRateId()));
			WcSaIndustryRateD codeRateD = wcSaIndustryRateDDao.getWcSaIndustryRateDByWcSaIndustryRateId(CommonUtil.toStringForId(orgCodeRateLink.getIndustryRateId()));

			if (CommonUtil.equals(variableName, "wcCodeRateId")) {
				rtnString = CommonUtil.toStringForId(orgCodeRateLink.getIndustryRateId());
			} else if (CommonUtil.equals(variableName, "wcCodeRateName")) {
				rtnString = codeRate.getIndustryName();
			} else if (CommonUtil.equals(variableName, "wcWicAnzic")) {
				rtnString = codeRate.getWic();
			} else if (CommonUtil.equals(variableName, "wcPercentage")) {
				rtnString = CommonUtil.toStringWithNoFormat(codeRateD.getPercentage());
			} else if (CommonUtil.equals(variableName, "wcStartDate")) {
				rtnString = CommonUtil.toString(codeRateD.getStartDate(), dateFormat);
			} else if (CommonUtil.equals(variableName, "wcEndDate")) {
				rtnString = CommonUtil.toString(codeRateD.getEndDate(), dateFormat);
			} else if (CommonUtil.equals(variableName, "wcWorkingState")) {
				rtnString = workingState;
			} else if (CommonUtil.equals(variableName, "wcWorkingStateMeaning")) {
				rtnString = CommonCodeManager.getCodeMeaning("STATES", workingState);
			}
		} else if (CommonUtil.equalsIgnoreCase(stateCode, "TAS")) {
			wcTasOrgCodeRateLinkDao.setDataSourceName(dataSource);
			wcTasCodeRateDao.setDataSourceName(dataSource);
			wcTasCodeRateDDao.setDataSourceName(dataSource);
			WcTasOrgCodeRateLink orgCodeRateLink = wcTasOrgCodeRateLinkDao.getWcTasOrgCodeRateLinkById(linkId);
			WcTasCodeRate codeRate = wcTasCodeRateDao.getWcTasCodeRateById(CommonUtil.toStringForId(orgCodeRateLink.getCodeRateId()));
			WcTasCodeRateD codeRateD = wcTasCodeRateDDao.getWcTasCodeRateDByWcTasCodeRateId(CommonUtil.toStringForId(orgCodeRateLink.getCodeRateId()));

			if (CommonUtil.equals(variableName, "wcCodeRateId")) {
				rtnString = CommonUtil.toStringForId(orgCodeRateLink.getCodeRateId());
			} else if (CommonUtil.equals(variableName, "wcCodeRateName")) {
				rtnString = codeRate.getCodeName();
			} else if (CommonUtil.equals(variableName, "wcWicAnzic")) {
				rtnString = codeRate.getAnzic();
			} else if (CommonUtil.equals(variableName, "wcPercentage")) {
				rtnString = CommonUtil.toStringWithNoFormat(codeRateD.getPercentage());
			} else if (CommonUtil.equals(variableName, "wcStartDate")) {
				rtnString = CommonUtil.toString(codeRateD.getStartDate(), dateFormat);
			} else if (CommonUtil.equals(variableName, "wcEndDate")) {
				rtnString = CommonUtil.toString(codeRateD.getEndDate(), dateFormat);
			} else if (CommonUtil.equals(variableName, "wcWorkingState")) {
				rtnString = workingState;
			} else if (CommonUtil.equals(variableName, "wcWorkingStateMeaning")) {
				rtnString = CommonCodeManager.getCodeMeaning("STATES", workingState);
			}
		} else if (CommonUtil.equalsIgnoreCase(stateCode, "VIC")) {
			wcVicOrgCodeRateLinkDao.setDataSourceName(dataSource);
			wcVicIndustryRateDao.setDataSourceName(dataSource);
			wcVicIndustryRateDDao.setDataSourceName(dataSource);
			WcVicOrgCodeRateLink orgCodeRateLink = wcVicOrgCodeRateLinkDao.getWcVicOrgCodeRateLinkById(linkId);
			WcVicIndustryRate codeRate = wcVicIndustryRateDao.getWcVicIndustryRateById(CommonUtil.toStringForId(orgCodeRateLink.getIndustryRateId()));
			WcVicIndustryRateD codeRateD = wcVicIndustryRateDDao.getWcVicIndustryRateDByWcVicIndustryRateId(CommonUtil.toStringForId(orgCodeRateLink.getIndustryRateId()));

			if (CommonUtil.equals(variableName, "wcCodeRateId")) {
				rtnString = CommonUtil.toStringForId(orgCodeRateLink.getIndustryRateId());
			} else if (CommonUtil.equals(variableName, "wcCodeRateName")) {
				rtnString = codeRate.getIndustryName();
			} else if (CommonUtil.equals(variableName, "wcWicAnzic")) {
				rtnString = codeRate.getWic();
			} else if (CommonUtil.equals(variableName, "wcPercentage")) {
				rtnString = CommonUtil.toStringWithNoFormat(codeRateD.getPercentage());
			} else if (CommonUtil.equals(variableName, "wcStartDate")) {
				rtnString = CommonUtil.toString(codeRateD.getStartDate(), dateFormat);
			} else if (CommonUtil.equals(variableName, "wcEndDate")) {
				rtnString = CommonUtil.toString(codeRateD.getEndDate(), dateFormat);
			} else if (CommonUtil.equals(variableName, "wcWorkingState")) {
				rtnString = workingState;
			} else if (CommonUtil.equals(variableName, "wcWorkingStateMeaning")) {
				rtnString = CommonCodeManager.getCodeMeaning("STATES", workingState);
			}
		} else if (CommonUtil.equalsIgnoreCase(stateCode, "WA")) {
			wcWaOrgCodeRateLinkDao.setDataSourceName(dataSource);
			wcWaCodeRateDao.setDataSourceName(dataSource);
			wcWaCodeRateDDao.setDataSourceName(dataSource);
			WcWaOrgCodeRateLink orgCodeRateLink = wcWaOrgCodeRateLinkDao.getWcWaOrgCodeRateLinkById(linkId);
			WcWaCodeRate codeRate = wcWaCodeRateDao.getWcWaCodeRateById(CommonUtil.toStringForId(orgCodeRateLink.getCodeRateId()));
			WcWaCodeRateD codeRateD = wcWaCodeRateDDao.getWcWaCodeRateDByWcWaCodeRateId(CommonUtil.toStringForId(orgCodeRateLink.getCodeRateId()));

			if (CommonUtil.equals(variableName, "wcCodeRateId")) {
				rtnString = CommonUtil.toStringForId(orgCodeRateLink.getCodeRateId());
			} else if (CommonUtil.equals(variableName, "wcCodeRateName")) {
				rtnString = codeRate.getCodeName();
			} else if (CommonUtil.equals(variableName, "wcWicAnzic")) {
				rtnString = codeRate.getAnzic();
			} else if (CommonUtil.equals(variableName, "wcPercentage")) {
				rtnString = CommonUtil.toStringWithNoFormat(codeRateD.getPercentage());
			} else if (CommonUtil.equals(variableName, "wcStartDate")) {
				rtnString = CommonUtil.toString(codeRateD.getStartDate(), dateFormat);
			} else if (CommonUtil.equals(variableName, "wcEndDate")) {
				rtnString = CommonUtil.toString(codeRateD.getEndDate(), dateFormat);
			} else if (CommonUtil.equals(variableName, "wcWorkingState")) {
				rtnString = workingState;
			} else if (CommonUtil.equals(variableName, "wcWorkingStateMeaning")) {
				rtnString = CommonCodeManager.getCodeMeaning("STATES", workingState);
			}
		}

		return rtnString;
	}
}