package com.jd.cotroller;

import com.github.pagehelper.PageInfo;
import com.jd.pojo.template.TypeTemplate;
import com.jd.service.TypeTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static com.jd.common.Constant.*;

@RestController
@RequestMapping("/typeTemplate")
public class TypeTemplateController {
    @Autowired
    TypeTemplateService typeTemplateService;

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public PageInfo<TypeTemplate> findByWhere(@RequestBody TypeTemplate template, Integer page, Integer rows){
        return typeTemplateService.findByWhere(template,page,rows).toPageInfo();
    }

    @RequestMapping(method = RequestMethod.POST)
    public String add(@RequestBody TypeTemplate template){
        try {
            if(!StringUtils.isEmpty(template.getName()))
                typeTemplateService.insert(template);
                return INSERT_SUCCESS;
        } catch (Exception e){
            return INSERT_FALSE;
        }
    }


    @RequestMapping(method = RequestMethod.PUT)
    public String update(@RequestBody TypeTemplate template){
        try {
            if(!StringUtils.isEmpty(template.getName()))
                typeTemplateService.update(template);
            return UPDATE_SUCCESS;
        } catch (Exception e) {
            return UPDATE_FALSE;
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public TypeTemplate findByKey(Long id ){
        return typeTemplateService.findByKey(id);
    }
}
