package tn.esprit.spring.dto;

import lombok.Data;

@Data
public class Reclamationtaux {
String title;
int taux ;
String text ;
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public int getTaux() {
	return taux;
}
public void setTaux(int taux) {
	this.taux = taux;
}
public String getText() {
	return text;
}
public void setText(String text) {
	this.text = text;
}

}
