package com.mycom.pa.spm.api.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

public class SpmIngestionElasticResponse{
	
	@JsonProperty
	private String id;
	
	@JsonProperty
	private String name;
	
	@JsonProperty
	private String type;
   
	public String getId() {
		return this.id;
	}

	public SpmIngestionElasticResponse setId(String id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return this.name;
	}
	
	public SpmIngestionElasticResponse setName(String name) {
		this.name = name;
		return this;
	}

	public String getType() {
		return this.type;
	}

	public SpmIngestionElasticResponse setType(String type) {
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
      if (!(obj instanceof SpmIngestionElasticResponse))
    	  return false;
      
      SpmIngestionElasticResponse dto = (SpmIngestionElasticResponse) obj;
      return Objects.equal(id, dto.id) && Objects.equal(name, dto.name) && Objects.equal(type, dto.type);
   }

}
