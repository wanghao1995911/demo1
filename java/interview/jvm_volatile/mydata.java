package interview.jvm_volatile;

import com.bfd.common.adapter.systemmanager.Organization;
import com.bfd.modules.entity.SysTagEntity;
import com.bfd.modules.vo.SysTagVo;

import java.util.List;
import java.util.Map;

/**
 * 标签配置表
 * 
 * @author yuxin.yan
 * @email yuxin.yan@percent.cn
 * @date 2020-01-02 14:26:11
 */
public interface SysTagService {
	
	/**
	 * 查询下级机构列表
	 * @param orgId
	 * @return
	 */
	List<Organization> queryChildrenOrgList(String orgId);

	/**
	 * 查询单条
	