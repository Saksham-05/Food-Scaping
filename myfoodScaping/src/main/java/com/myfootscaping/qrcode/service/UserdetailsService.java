package com.myfootscaping.qrcode.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfootscaping.qrcode.dao.Feedbackdto;
import com.myfootscaping.qrcode.dao.Fooditemqueriesdto;
import com.myfootscaping.qrcode.dao.UserdetailsitemsDTO;
import com.myfootscaping.qrcode.entity.Feedback;
import com.myfootscaping.qrcode.entity.FeedbackRepo;
import com.myfootscaping.qrcode.entity.Fooditemqueries;
import com.myfootscaping.qrcode.entity.FooditemqueriesRepo;
import com.myfootscaping.qrcode.entity.Product;
import com.myfootscaping.qrcode.entity.ProductRepository;
import com.myfootscaping.qrcode.entity.Userdetails;
import com.myfootscaping.qrcode.entity.UserdetailsRepo;


 
@Service
@Transactional
public class UserdetailsService {
 
    @Autowired
    private UserdetailsRepo repo;
     
    @Autowired
    private FooditemqueriesRepo frepo;
    
    @Autowired
    private FeedbackRepo feedbackRepo;
    
    public List<UserdetailsitemsDTO> listAll() {
    	List<Userdetails> list = repo.findAll();
    	List<UserdetailsitemsDTO> userdetailsitemsDTO = new ArrayList<UserdetailsitemsDTO>();
    	for (int i = 0; i < list.size(); i++) {
    		System.out.println("1 "+list.get(i).toString());
    		UserdetailsitemsDTO u = new UserdetailsitemsDTO(list.get(i).getUserid(), list.get(i).getPostalcode(), list.get(i).getContainerid(), list.get(i).getIsfoodpicked());
    		for (int j = 0; j < list.get(i).getFooditemqueries().size(); j++) {
    			Fooditemqueries ft = list.get(i).getFooditemqueries().get(j);
    			Fooditemqueriesdto f = new Fooditemqueriesdto(ft.getItemname(), ft.getEatnow(), ft.getTakehome(), ft.getTriedbefore());
				System.out.println("2 "+list.get(i).getFooditemqueries().get(j).toString());
				u.getFooditemqueries().add(f);
			}
			userdetailsitemsDTO.add(u);
		}
        return userdetailsitemsDTO;
    }
     
    public UserdetailsitemsDTO save(UserdetailsitemsDTO userdetails) {
    	
    	Userdetails u = new Userdetails();
//    	u.setUserid(userdetails.getUserid());
    	u.setPostalcode(userdetails.getPostalcode());
    	u.setContainerid(userdetails.getContainerid());
    	u.setIsfoodpicked(userdetails.getIsfoodpicked());
    	
    	for (int i = 0; i < userdetails.getFooditemqueries().size(); i++) {
			Fooditemqueriesdto fqo = userdetails.getFooditemqueries().get(i);
			Fooditemqueries ft = new Fooditemqueries();
			
			ft.setEatnow(fqo.getEatnow());
	    	ft.setItemname(fqo.getItemname());
	    	ft.setTakehome(fqo.getTakehome());
	    	ft.setTriedbefore(fqo.getTriedbefore());
	    	ft.setUserdetails(u);
	    	System.out.println(ft.toString());
	    	u.getFooditemqueries().add(ft);
		}
    	

    	System.out.println(u.toString());
        Userdetails val = repo.save(u);
        UserdetailsitemsDTO dto = new UserdetailsitemsDTO();
        if(Objects.nonNull(val.getUserid())){
        	dto.setUserid(val.getUserid());
        	dto.setPostalcode(val.getPostalcode());
        	dto.setIsfoodpicked(val.getIsfoodpicked());
        	dto.setContainerid(val.getContainerid());
        	return dto;	
        }else {
        	return dto;
        }
    }
    
    public boolean saveUserFeedback(Feedbackdto feedbackdto, Integer id) {
    	
    	Userdetails us = get(id);
    	
    	Feedback fd = new Feedback();
    	
    	if(Objects.nonNull(us.getUserid())) {
    		fd.setFeedbackmsg(feedbackdto.getFeedbackmessage());
    		fd.setUserdetail(us);
    		
    		Feedback fdr = feedbackRepo.save(fd);
    		if(Objects.nonNull(fdr.getFeedbackid())){
            	return true;	
            }else {
            	return false;
            }
    	}else {
    		return false;
    	}
    	
    }
     
    public Userdetails get(Integer id) {
        return repo.findById(id).get();
    }
     
    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
