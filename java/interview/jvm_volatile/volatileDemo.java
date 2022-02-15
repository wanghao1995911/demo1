package interview.jvm_volatile;

import com.bfd.modules.entity.AddressEntity;
import com.bfd.modules.vo.AddressVo;

import java.util.List;
import java.util.Map;

/**
 * 地址信息表
 * 
 * @author yiwei.li
 * @email yiwei.li@baifendian.com
 * @date 2020-07-07 11:27:45
 */
public interface AddressService {

	/**
	 * 查询实体
	 * @param name
	 * @return
	 */
	AddressEntity queryObject(String name);
	/**
	 * 查询列表
	 * @param map
	 * @return
	 */
	List<AddressEntity> queryList(Map<String, Object> map);
	/**
	 * 查询总数
	 * @param map
	 * @return
	 */
	int queryTotal(Map<String, Object> map);
	/**
	 * 查询地名联想及经纬度
	 * @param name
	 * @return
	 */
	List<AddressVo> queryListByName(String name);
	
}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             