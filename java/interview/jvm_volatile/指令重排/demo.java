package interview.jvm_volatile.指令重排;

import com.bfd.modules.entity.MessageEntity;
import com.bfd.modules.vo.MessageVo;

import java.util.List;

/**
 * 消息提醒
 *
 * @author mingyu.shi
 * @email mingyu.shi@percent.cn
 * @date 2020-02-06 08:09:39
 */
public interface MessageService {

    /**
     * 消息提醒
     * @return
     */
    List<MessageVo> messages();

    /**
     * 新增任务消息提醒
     * @param entity
     */
    void saveTaskMessage(MessageEntity entity);

    /**
     * 新增截至一小时消息提醒
     * @param entity
     */
    void saveTaskOneHourMessage(MessageEntity entity);

    /**
     * 标记已读
     * @param id
     * @param type
     */
    void markRead(String id