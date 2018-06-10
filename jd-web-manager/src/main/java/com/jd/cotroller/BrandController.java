package com.jd.cotroller;

import com.github.pagehelper.PageInfo;
import com.jd.pojo.entity.Result;
import com.jd.pojo.good.Brand;
import com.jd.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static com.jd.common.Constant.*;

@RestController
@RequestMapping(value = "/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    @RequestMapping(method = RequestMethod.POST)
   public String add(@RequestBody Brand brand){
        try {
            brandService.insert(brand);
            return INSERT_SUCCESS;
        } catch (Exception e) {
            return INSERT_FALSE;
        }
    }


    @RequestMapping(method = RequestMethod.PUT)
    public String update(@RequestBody Brand brand){
        try {
            brandService.update(brand);
            return UPDATE_SUCCESS;
        } catch (Exception e) {
            return UPDATE_FALSE;
        }
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public String delete(Long[] ids){
        try {
            brandService.delete(ids);
            return DEL_SUCCESS;
        } catch (Exception e) {
            return DEL_FALSE;
        }
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Brand findByKey(@PathVariable("id") Long id ){
        return  brandService.findByKey(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Brand> findAll(){
        return brandService.findAll();
    }

//    @RequestMapping(value = "/page", method= RequestMethod.POST)
//    public PageInfo<Brand> findByWhere(@RequestBody Brand brand,Integer pageNum,Integer pageSize){
//        return brandService.findByWhere(brand,pageNum,pageSize);
//    }

    @RequestMapping(value = "/search", method= RequestMethod.POST)
    public PageInfo<Brand> findByWhere(@RequestBody Brand brand, Integer page, Integer rows){
        return brandService.findByWhere(brand,page,rows);
    }

    @RequestMapping(value = "/selectOptionList", method= RequestMethod.GET)
    public List<Map> selectOptionList(){
        List<Map> list = brandService.selectOptionList();
        return list;
    }


}
