/**************************************************************************************************
 * Framework Generated DAO Source
 * - HP_COMMENTS - 
 *************************************************************************************************/
package project.conf.resource.ormapper.dao.HpComments;

import project.conf.resource.ormapper.dto.oracle.HpComments;
import zebra.base.IDao;

public interface HpCommentsDao extends IDao {
	public HpComments getCommentsByCommentId(String commentId) throws Exception;
}