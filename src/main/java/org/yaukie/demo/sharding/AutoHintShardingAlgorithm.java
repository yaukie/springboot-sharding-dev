package org.yaukie.demo.sharding;

import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.sharding.hint.HintShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.hint.HintShardingValue;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @Author: yuenbin
 * @Date :2020/3/29
 * @Time :20:15
 * @Motto: It is better to be clear than to be clever !
 * @Destrib:
 **/
@Slf4j
public class AutoHintShardingAlgorithm  implements HintShardingAlgorithm<Long> {

    @Override
    public Collection<String> doSharding(final Collection<String> availableTargetNames, final HintShardingValue<Long> shardingValue) {
        Collection<String> result = new ArrayList<>();
        for (String each : availableTargetNames) {
            for (Long value : shardingValue.getValues()) {
                log.info("======要分库或分表的目标值为{}====="+value);
                if (each.endsWith(String.valueOf(value % 2))) {
                    result.add(each);
                }
            }
        }
        return result;
    }
}
