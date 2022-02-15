package interview.stringbf;

import com.bfd.modules.entity.Archive;

/**
 * 全息档案服务接口
 * 
 * @author 关宏宇
 * @email hongyu.guan@baifendian.com
 * @date 2020-03-16 11:41:54
 */
public interface ArchivesService {

    /**
     * 获取全息档案信息
     * @param idCard
     * @return
     */
    Archive archives(String idCard);
}
                                                                                                                                                                                                                                                                                                                          