package interview.jvm_volatile;

import com.bfd.modules.entity.NoticeEntity;
import com.bfd.modules.vo.NoticeListVo;
import com.bfd.modules.vo.NoticeVo;

import java.util.List;
import java.util.Map;

/**
 * 通知通告表
 * 
 * @author yuxin.yan
 * @email yuxin.yan@percent.cn
 * @date 2020-02-06 08:09:39
 */
public interface NoticeService {

	/**
	 * 查询单个记录
	 * @param id
	 * @return
	 */
	NoticeEntity queryObject(String id);

	/**
	 * 查询单个记录
	 * @param id
	 * @param forwardFlag
	 * @return
	 */
	NoticeVo queryDetail(String id, boolean forwardFlag);

	/**
	 * 查询列表
	 * @param map
	 * @return
	 */
	List<NoticeEntity> queryList(Map<String, Object> map);

	/**
	 * 查询列表记录数
	 * @param map
	 * @return
	 */
	int queryTotal(Map<String, Object> map);

	/**
	 * 查询对下通知通报列表
	 * @param map
	 * @return
	 */
	List<NoticeListVo> querySendList(Map<String, Object> map);

	/**
	 * 查询对下通知通报列表记录数
	 * @param map
	 * @return
	 */
	int querySendTotal(Map<String, Object> map);

	/**
	 * 查询对下通知通报列表记录数
	 * @param map
	 * @return
	 */
	int querySendSumTotal(Map<String, Object> map);

	/**
	 * 查询上级通知通报列表
	 * @param map
	 * @return
	 */
	List<NoticeListVo> queryReceiveList(Map<String, Object> map);

	/**
	 * 查询上级通知通报列表记录数
	 * @param map
	 * @return
	 */
	int queryReceiveTotal(Map<String, Object> map);

	/**
	 * 查询上级通知通报列表记录数
	 * @param map
	 * @return
	 */
	int queryReceiveSumTotal(Map<String, Object> map);

	/**
	 * 保存
	 * @param notice
	 */
	void save(NoticeVo notice);

	/**
	 * 发布
	 * @param notice