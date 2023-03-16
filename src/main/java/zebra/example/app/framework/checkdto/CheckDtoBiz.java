package zebra.example.app.framework.checkdto;

import zebra.data.ParamEntity;

public interface CheckDtoBiz {
	public ParamEntity getDefault(ParamEntity paramEntity) throws Exception;
	public ParamEntity getList(ParamEntity paramEntity) throws Exception;
	public ParamEntity getColumns(ParamEntity paramEntity) throws Exception;
}