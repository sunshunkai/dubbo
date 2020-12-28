package org.apache.dubbo.demo.provider.filter;

import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.common.utils.StringUtils;
import org.apache.dubbo.rpc.*;

import java.util.UUID;

/**
 * @author ssk
 * @date 2020/12/28
 */
@Activate(group = {CommonConstants.PROVIDER})
public class DubboProviderLogFilter implements Filter {

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        RpcContext context = RpcContext.getContext();

        String dubboTraceId = context.getAttachment("dubboTraceId");
        if(StringUtils.isEmpty(dubboTraceId)){
            dubboTraceId = UUID.randomUUID().toString();
            context.setAttachment("dubboTraceId",dubboTraceId);
        }

        System.out.println("生产者dubboTraceId:"+dubboTraceId);

        return invoker.invoke(invocation);
    }
}
