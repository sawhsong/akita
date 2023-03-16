package zebra.example.app.framework.sourcegenerator;

import zebra.data.ParamEntity;

public interface SourceGeneratorBiz {
	public ParamEntity getDefault(ParamEntity paramEntity) throws Exception;
	public ParamEntity getList(ParamEntity paramEntity) throws Exception;
	public ParamEntity getGeneratorInfo(ParamEntity paramEntity) throws Exception;
	public ParamEntity exeGenerateN(ParamEntity paramEntity) throws Exception;
	public ParamEntity exeGenerateC(ParamEntity paramEntity) throws Exception;
}