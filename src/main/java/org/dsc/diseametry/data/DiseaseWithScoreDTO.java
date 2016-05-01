package org.dsc.diseametry.data;

import org.dsc.diseametry.domain.Disease;
import org.springframework.data.neo4j.annotation.QueryResult;
import org.springframework.data.neo4j.annotation.ResultColumn;

@QueryResult
public class DiseaseWithScoreDTO {
	@ResultColumn("disease") private Disease disease;
	@ResultColumn("score") private Integer score;
	
	public Disease getDisease() {
		return disease;
	}
	
	public void setDisease(Disease disease) {
		this.disease = disease;
	}
	
	public Integer getScore() {
		return score;
	}
	
	public void setScore(Integer score) {
		this.score = score;
	}
}