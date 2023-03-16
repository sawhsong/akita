/**************************************************************************************************
 * Framework Generated HDAOImpl Source
 * - HP_COMMENTS - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.HpComments;

import project.common.extend.BaseHDao;
import project.conf.resource.ormapper.dto.oracle.HpComments;
import zebra.data.QueryAdvisor;

public class HpCommentsHDaoImpl extends BaseHDao implements HpCommentsDao {
	public HpComments getCommentsByCommentId(String commentId) throws Exception {
		QueryAdvisor queryAdvisor = new QueryAdvisor();
		queryAdvisor.addWhereClause("comment_id = '"+commentId+"'");
		return (HpComments)selectAllToDto(queryAdvisor, new HpComments());
	}
}