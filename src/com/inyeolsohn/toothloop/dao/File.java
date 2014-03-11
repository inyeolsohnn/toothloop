package com.inyeolsohn.toothloop.dao;

import org.springframework.web.multipart.MultipartFile;  
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

public class File {  
  
 private MultipartFile file;  
  
 public MultipartFile getFile() {  
  return file;  
 }  
  
 public void setFile(MultipartFile file) {  
  this.file = file;  
 }  
}  
