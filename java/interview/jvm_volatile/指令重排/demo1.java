package interview.jvm_volatile.指令重排;

import com.bfd.modules.entity.NetDiskEntity;
import com.bfd.modules.vo.ImportantIntelVo;
import com.bfd.modules.vo.NetDiskVo;
import org.springframework.lang.Nullable;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author author
 * @email wei.yang@percent.cn
 * @date 2020-03-31 16:30:47
 */
public interface NetDiskService {
	
    /**
	 * 文档详情
	 * @param id
	 * @return
	 */
	NetDiskEntity queryObject(String id);
    /**
	 * 文档列表
	 * @param map
	 * @return
	 */
	List<NetDiskVo> queryList(Map<String, Object> map);
    /**
	 * 文档总数
	 * @param map
	 * @return
	 */
	int queryTotal(Map<String, Object> map);
	
    /**
	 * 保存
	 * @param netDisk
	 */
	void save(NetDiskEntity netDisk);
    /**
	 * 更新
	 * @param netDisk
	 */
	void update(NetDiskEntity netDisk);
    /**
	 * 删除
	 * @param id
	 */
	void delete(String id);
    /**
	 * 批量�