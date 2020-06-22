package cuiyi.itsource.hrm.client;

import cuiyi.itsource.hrm.client.impl.SystemdictionaryItemClientImpl;
import cuiyi.itsource.hrm.domain.SystemdictionaryItem;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "system-service",path = "/systemdictionaryItem",fallback = SystemdictionaryItemClientImpl.class)
public interface SystemdictionaryItemClient {

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    SystemdictionaryItem get(@PathVariable("id")Long id);
}
