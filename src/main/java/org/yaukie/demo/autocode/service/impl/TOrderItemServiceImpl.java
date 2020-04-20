
        package org.yaukie.demo.autocode.service.impl;


        import org.yaukie.demo.autocode.dao.mapper.TOrderItemMapper;
        import org.yaukie.demo.autocode.model.TOrderItem;
        import org.yaukie.demo.autocode.model.TOrderItemExample;
        import org.yaukie.api.base.core.BaseService;
        import org.yaukie.demo.autocode.service.api.TOrderItemService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;
        import org.springframework.transaction.annotation.Transactional;



        /**
        * @author: yuenbin
        * @create: 2020/03/29 21/19/735
        **/
        @Service
        @Transactional
        public class TOrderItemServiceImpl extends BaseService<TOrderItemMapper,TOrderItem,TOrderItemExample> implements TOrderItemService {

        @Autowired
        private TOrderItemMapper tOrderItemMapper;

        }
