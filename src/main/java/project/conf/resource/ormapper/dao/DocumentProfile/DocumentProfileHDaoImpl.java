/**************************************************************************************************
 * Framework Generated HDAOImpl Source
 * - DOCUMENT_PROFILE - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.DocumentProfile;

import project.common.extend.BaseHDao;
import zebra.data.DataSet;
import zebra.data.QueryAdvisor;
import zebra.util.CommonUtil;

public class DocumentProfileHDaoImpl extends BaseHDao implements DocumentProfileDao {
	public DataSet getProfileForSelectbox() throws Exception {
		return selectAsDataSet(new QueryAdvisor(), "query.DocumentProfile.getProfileForSelectbox");
	}

	public String getProfileHtmlStringForSelectbox(String attributes) throws Exception {
		String html = "", attrStr = "", preOptGroup = "";
		String attrs[];
		DataSet ds = getProfileForSelectbox();

		if (CommonUtil.isNotBlank(attributes)) {
			attrs = CommonUtil.split(attributes, ";");
			for (String attr : attrs) {
				String name = CommonUtil.split(attr, ":")[0];
				String value = CommonUtil.split(attr, ":")[1];
				attrStr += " "+name+"=\""+value+"\"";
			}
		}

		html += "<select"+attrStr+">";
		html += "<option value=\"\">==Select==</option>";
		for (int i=0; i<ds.getRowCnt(); i++) {
			if (!CommonUtil.equals(preOptGroup, ds.getValue(i, "PROFILE_GROUP"))) {
				if (i != 0) {
					html += "</optgroup>";
				}
				html += "<optgroup label=\""+ds.getValue(i, "PROFILE_GROUP_MEANING")+"\">";
			}
			html += "<option value=\""+ds.getValue(i, "PROFILE_ID")+"\">"+ds.getValue(i, "PROFILE_NAME")+"</option>";

			preOptGroup = ds.getValue(i, "PROFILE_GROUP");
		}
		html += "</select>";

		return html;
	}
}