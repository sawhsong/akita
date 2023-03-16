package zebra.example.common.schedule;

import java.util.Iterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import zebra.example.common.module.commoncode.ZebraCommonCodeManager;
import zebra.example.common.module.key.ZebraKeyManager;
import zebra.example.conf.resource.ormapper.dao.ZebraBoard.ZebraBoardDao;
import zebra.example.conf.resource.ormapper.dto.oracle.ZebraBoard;
import zebra.util.CommonUtil;
import zebra.util.ConfigUtil;

public class ZebraBoardArticleCreationJob extends QuartzJobBean {
	private Logger logger = LogManager.getLogger(getClass());
	private ZebraBoardDao zebraBoardDao;

	public void setZebraBoardDao(ZebraBoardDao zebraBoardDao) {
		this.zebraBoardDao = zebraBoardDao;
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
			ZebraBoard zebraBoard = new ZebraBoard();

			logger.debug("ZebraBoardArticleCreationJob Begin : "+CommonUtil.getSysdate("yyyy-MM-dd HH:mm:ss"));

			zebraBoard.setArticleId(ZebraKeyManager.getId("ZEBRA_BOARD_S"));
			if (CommonUtil.toInt(CommonUtil.substring(uid, 0, 3)) % 2 == 0) {
				zebraBoard.setBoardType(ZebraCommonCodeManager.getCodeByConstants("BOARD_TYPE_NOTICE"));

				contents += "ZebraBoardArticleCreationJob System generated article - "+CommonUtil.getSysdate("yyyy-MM-dd HH:mm:ss")+" - "+uid+"\n\n";
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

				zebraBoard.setBoardType(ZebraCommonCodeManager.getCodeByConstants("BOARD_TYPE_FREE"));

				contents += "ZebraBoardArticleCreationJob System generated article - "+CommonUtil.getSysdate("yyyy-MM-dd HH:mm:ss")+" - "+uid+"</br></br>";
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
			zebraBoard.setWriterId("0");
			zebraBoard.setWriterName("ZebraBoardArticleCreationJob");
			zebraBoard.setWriterEmail(ConfigUtil.getProperty("mail.default.from"));
			zebraBoard.setWriterIpAddress("127.0.0.1");
			zebraBoard.setArticleSubject("ZebraBoardArticleCreationJob System generated article - "+CommonUtil.getSysdate("yyyy-MM-dd HH:mm:ss")+" - "+uid);
			zebraBoard.setArticleContents(contents);
			zebraBoard.setInsertUserId("0");
			zebraBoard.setInsertDate(CommonUtil.toDate(CommonUtil.getSysdate()));
			zebraBoard.setRefArticleId("-1");

			zebraBoardDao.insert(zebraBoard);

			logger.debug("ZebraBoardArticleCreationJob End : "+CommonUtil.getSysdate("yyyy-MM-dd HH:mm:ss"));
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.error(ex);
		}
	}
}