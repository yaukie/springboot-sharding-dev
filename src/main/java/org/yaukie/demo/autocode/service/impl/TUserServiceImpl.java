
        package org.yaukie.demo.autocode.service.impl;


        import org.yaukie.demo.autocode.dao.mapper.TUserMapper;
        import org.yaukie.demo.autocode.model.TUser;
        import org.yaukie.demo.autocode.model.TUserExample;
        import org.yaukie.api.base.core.BaseService;
        import org.yaukie.demo.autocode.service.api.TUserService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;
        import org.springframework.transaction.annotation.Transactional;



        /**
        * @author: yuenbin
        * @create: 2020/03/29 21/19/735
        **/
        @Service
        @Transactional
        public class TUserServiceImpl extends BaseService<TUserMapper,TUser,TUserExample> implements TUserService {

        @Autowired
        private TUserMapper tUserMapper;

        }
