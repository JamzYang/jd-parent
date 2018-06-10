package com.jd.cotroller;

import com.github.pagehelper.PageInfo;
import static com.jd.common.Constant.*;
import com.jd.pojo.specification.Specification;
import com.jd.service.SpecificationSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/specification")
public class SpecificationController {
    @Autowired
    private SpecificationSerivce specificationSerivce ;

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public PageInfo<Specification> findByWhere(@RequestBody Specification spec, Integer page, Integer rows){
        return specificationSerivce.findByWhere(spec,page,rows).toPageInfo();
    }

    @RequestMapping(method = RequestMethod.POST)
    public String add(@RequestBody Specification spec){
       try {
           if(!StringUtils.isEmpty(spec.getSpecName()))
               specificationSerivce.insert(spec);
           return INSERT_SUCCESS;
       } catch (Exception e){
           return INSERT_FALSE;
       }
    }

    @RequestMapping(method = RequestMethod.PUT)
    public String update(@RequestBody Specification spec){
        try {
            if(!StringUtils.isEmpty(spec.getSpecName()))
                specificationSerivce.update(spec);
            return UPDATE_SUCCESS;
        } catch (Exception e) {
            return UPDATE_FALSE;
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public Specification findByKey(Long id ){
        return specificationSerivce.findByKey(id);
    }

    @RequestMapping(value = "/selectOptionList")
    public List<Map> selectOptionList(Long id ){
        return specificationSerivce.selectOptionList();
    }
}
