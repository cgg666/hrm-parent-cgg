package cuiyi.itsource.hrm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cuiyi.itsource.hrm.domain.Systemdictionary;
import cuiyi.itsource.hrm.domain.SystemdictionaryItem;
import cuiyi.itsource.hrm.mapper.SystemdictionaryItemMapper;
import cuiyi.itsource.hrm.mapper.SystemdictionaryMapper;
import cuiyi.itsource.hrm.service.ISystemdictionaryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cuigege
 * @since 2020-06-19
 */
@Service
public class SystemdictionaryItemServiceImpl extends ServiceImpl<SystemdictionaryItemMapper, SystemdictionaryItem> implements ISystemdictionaryItemService {

    @Autowired
    private SystemdictionaryMapper systemdictionaryMapper;

    /**
     * 根据目录查询明细
     * @param sn
     * @return
     */
    @Override
    public List<SystemdictionaryItem> getBySn(String sn) {
        Systemdictionary systemdictionary = systemdictionaryMapper.selectOne(new QueryWrapper<Systemdictionary>()
                .eq("sn", sn));
        //通过业务代码规避空指针异常，运行时异常，通常不捕获
        if(systemdictionary==null){
            return null;
        }
        return baseMapper.selectList(new QueryWrapper<SystemdictionaryItem>()
                .eq("parent_id",systemdictionary.getId()));
    }

}
