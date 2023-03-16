package project.common.schedule;

import java.util.Iterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import project.common.module.commoncode.CommonCodeManager;
import project.common.module.key.KeyManager;
import project.conf.resource.ormapper.dao.SysBoard.SysBoardDao;
import project.conf.resource.ormapper.dto.oracle.SysBoard;
import zebra.util.CommonUtil;
import zebra.util.ConfigUtil;

public class BoardArticleCreationJob extends QuartzJobBean {
	private Logger logger = LogManager.getLogger(BoardArticleCreationJob.class);
	private SysBoardDao sysBoardDao;

	public void setSysBoardDao(SysBoardDao sysBoardDao) {
		this.sysBoardDao = sysBoardDao;
	}

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		addBoard(context);
	}

	@SuppressWarnings("rawtypes")
	private void addBoard(JobExecutionContext context) {
		String uid = CommonUtil.uid();
		String contents = "";

		try {
			SysBoard sysBoard = new SysBoard();

			logger.debug("BoardArticleCreationJob Begin : "+CommonUtil.getSysdate("yyyy-MM-dd HH:mm:ss"));

			sysBoard.setArticleId(KeyManager.getId("SYS_BOARD_S"));
			if (CommonUtil.toInt(CommonUtil.substring(uid, 0, 3)) % 2 == 0) {
				sysBoard.setBoardType(CommonCodeManager.getCodeByConstants("BOARD_TYPE_NOTICE"));

				contents += "BoardArticleCreationJob System generated article - "+CommonUtil.getSysdate("yyyy-MM-dd HH:mm:ss")+" - "+uid+"\n\n";
				contents += "context.getFireInstanceId() : "+context.getFireInstanceId()+"\n";
				contents += "context.getJobRunTime() : "+CommonUtil.toString(context.getJobRunTime()/1000, "#,##0.00")+"\n";
				contents += "context.getRefireCount() : "+context.getRefireCount()+"\n";
				contents += "context.getFireTime() : "+CommonUtil.toString(context.getFireTime(), ConfigUtil.getProperty("format.dateTime.java"))+"\n";
				contents += "context.getPreviousFireTime() : "+CommonUtil.toString(context.getPreviousFireTime(), ConfigUtil.getProperty("format.dateTime.java"))+"\n";
				contents += "context.getNextFireTime() : "+CommonUtil.toString(context.getNextFireTime(), ConfigUtil.getProperty("format.dateTime.java"))+"\n\n";
				contents += "System Generated UID : "+uid+"\n";
			} else {
				JobDetail jobDetail = context.getJobDetail();
				JobDataMap jobDataMap = jobDetail.getJobDataMap();

				sysBoard.setBoardType(CommonCodeManager.getCodeByConstants("BOARD_TYPE_FREE"));

				contents += "BoardArticleCreationJob System generated article - "+CommonUtil.getSysdate("yyyy-MM-dd HH:mm:ss")+" - "+uid+"</br></br>";
				contents += "context.getFireInstanceId() : "+context.getFireInstanceId()+"</br>";
				contents += "context.getJobRunTime() : "+CommonUtil.toString(context.getJobRunTime()/1000, "#,##0.00")+"</br>";
				contents += "context.getRefireCount() : "+context.getRefireCount()+"</br>";
				contents += "context.getFireTime() : "+CommonUtil.toString(context.getFireTime(), ConfigUtil.getProperty("format.dateTime.java"))+"</br>";
				contents += "context.getPreviousFireTime() : "+CommonUtil.toString(context.getPreviousFireTime(), ConfigUtil.getProperty("format.dateTime.java"))+"</br>";
				contents += "context.getNextFireTime() : "+CommonUtil.toString(context.getNextFireTime(), ConfigUtil.getProperty("format.dateTime.java"))+"</br></br>";
				contents += "jobDetail.getDescription() : "+jobDetail.getDescription()+"</br></br>";
				contents += "System Generated UID : "+uid+"</br></br>";
				for (Iterator keys = jobDataMap.keySet().iterator(); keys.hasNext();) {
					String key = (String)keys.next();
					contents += "jobDataMap("+key+") : "+jobDataMap.get(key)+"</br>";
				}
			}
			sysBoard.setWriterId("0");
			sysBoard.setWriterName("BoardArticleCreationJob");
			sysBoard.setWriterEmail(ConfigUtil.getProperty("mail.default.from"));
			sysBoard.setWriterIpAddress("127.0.0.1");
			sysBoard.setArticleSubject("BoardArticleCreationJob System generated article - "+CommonUtil.getSysdate("yyyy-MM-dd HH:mm:ss")+" - "+uid);
			sysBoard.setArticleContents(contents);
			sysBoard.setInsertUserId("0");
			sysBoard.setInsertDate(CommonUtil.toDate(CommonUtil.getSysdate()));
			sysBoard.setParentArticleId("-1");

			sysBoardDao.insert(sysBoard);

			logger.debug("BoardArticleCreationJob End : "+CommonUtil.getSysdate("yyyy-MM-dd HH:mm:ss"));
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error(ex);
		}
	}
}