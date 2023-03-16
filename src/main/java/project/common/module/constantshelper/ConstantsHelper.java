package project.common.module.constantshelper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import zebra.util.CommonUtil;

public class ConstantsHelper {
	@SuppressWarnings("unused")
	private static Logger logger = LogManager.getLogger(ConstantsHelper.class);

	public static boolean hasPortalTab(String personType) {
		if (CommonUtil.isBlank(personType)) {return false;}

		String personTypeForPortalTab[] = {"ECMS IPro", "ECMS IC", "ECMS Sponsored IPro", "ECMS Prospect", "BO Employee", "EST ECMS Sponsored IPro", "NZ IC", "NZ IPro", "NZ Prospect",
				"ECMS Elite Premium IC", "ECMS EES IPro", "ECMS EES IC", "ECMS ESSG Contractor", "ECMS ESSG Pte Ltd Contractor", "ECMS ESSG SPass Contractor", "ECMS ESUK IPro",
				"ECMS ESUK IC", "ECMS ESMY Contractor", "ECMS EES IPro", "ECMS EES IC", "ECMS ESHK Ltd Co Contractor", "UoM Sole Trader","UoM IC", "ECMS Third Party Worker", "ECMS EES Sole Trader", "ECMS Sole Trader"};
		String[] personTypes = CommonUtil.splitWithTrim(personType, ",");

		for (String type : personTypes) {
			if (CommonUtil.isInIgnoreCase(type, personTypeForPortalTab)) {
				return true;
			}
		}

		return false;
	}
}