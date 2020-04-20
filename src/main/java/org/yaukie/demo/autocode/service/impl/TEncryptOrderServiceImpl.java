
        package org.yaukie.demo.autocode.service.impl;


        import org.yaukie.demo.autocode.dao.mapper.TEncryptOrderMapper;
        import org.yaukie.demo.autocode.model.TEncryptOrder;
        import org.yaukie.demo.autocode.model.TEncryptOrderExample;
        import org.yaukie.api.base.core.BaseService;
        import org.yaukie.demo.autocode.service.api.TEncryptOrderService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;
        import org.springframework.transaction.annotation.Transactional;



        /**
        * @author: yuenbin
        * @create: 2020/03/30 09/45/603
        **/
        @Service
        @Transactional
        public class TEncryptOrderServiceImpl extends BaseService<TEncryptOrderMapper,TEncryptOrder,TEncryptOrderExample> implements TEncryptOrderService {

        @Autowired
        private TEncryptOrderMapper tEncryptOrderMapper;

        }
