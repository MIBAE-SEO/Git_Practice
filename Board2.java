package kr.or.sol.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="BOARD2")
public class Board2 implements Serializable{
	private static final long serialVersionUID=1L;

public Board2() {
	super();
}
   @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="bd2_seq")
   @SequenceGenerator(name="bd2_seq",sequenceName="BD2_SEQ",initialValue=1, allocationSize =1)
   @Id
   private int seq;
   
   private int cnt;
   private String writer;
   private String title;
   private String content;
   
   @Temporal(TemporalType.DATE)
   private Date createDate;

   public int getSeq() {
      return seq;
   }

   public void setSeq(int seq) {
      this.seq = seq;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public String getWriter() {
      return writer;
   }

   public void setWriter(String writer) {
      this.writer = writer;
   }

   public String getContent() {
      return content;
   }

   public void setContent(String content) {
      this.content = content;
   }

   public Date getCreateDate() {
      return createDate;
   }

   public void setCreateDate(Date createDate) {
      this.createDate = createDate;
   }

  

public int getCnt() {
	return cnt;
}

public void setCnt(int cnt) {
	this.cnt = cnt;
}



public static long getSerialversionuid() {
	return serialVersionUID;
}

@Override
   public String toString() {
      return "Board [seq=" + seq + ", title=" + title + ", writer=" + writer + ", content=" + content
            + ", createDate=" + createDate + ", cnt=" + cnt + "]";
   }
}