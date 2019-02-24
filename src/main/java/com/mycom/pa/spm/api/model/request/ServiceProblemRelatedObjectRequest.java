package com.mycom.pa.spm.api.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

public class ServiceProblemRelatedObjectRequest{
	
	@JsonProperty
	private String id;
	
	@JsonProperty
	private String name;
	
	@JsonProperty
	private String type;
   
	public String getId() {
		return this.id;
	}

	public ServiceProblemRelatedObjectRequest setId(String id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return this.name;
	}
	
	public ServiceProblemRelatedObjectRequest setName(String name) {
		this.name = name;
		return this;
	}

	public String getType() {
		return this.type;
	}

	public ServiceProblemRelatedObjectRequest setType(String type) {
		this.type = type;
		return this;
	}



   @Override
   public String toString(){
      return Objects.toStringHelper(this).add("id", id).add("name", name).add("type", type).toString();
   }

   @Override
   public int hashCode(){
      return Objects.hashCode(id, name, type);
   }

   @Override
   public boolean equals(Object obj){
      if (!(obj instanceof ServiceProblemRelatedObjectRequest))
    	  return false;
      
      ServiceProblemRelatedObjectRequest dto = (ServiceProblemRelatedObjectRequest) obj;
      return Objects.equal(id, dto.id) && Objects.equal(name, dto.name) && Objects.equal(type, dto.type);
   }

}
