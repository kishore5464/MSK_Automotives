package com.msk.automotive.service.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "service_invoice_card")
public class Service_Invoice_Card implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String service_id;

	private Customer_Details customer_Details;
	private Service_Type service_Type;
	private Service_Advisor service_Adviser;

	private String service_detail;
	private String tool_kit;
	private String spare_wheel;
	private String jack;
	private String jack_handler;
	private String car_perfume;
	private String clock;
	private String cd_player;
	private Integer kilometer;
	private Card_Type card_type;
	private Card_Status card_status;
	private Date current_service_date;
	private Date service_expire_date;
	private Double total_amount;
	private Date created_date;

	public Service_Invoice_Card() {
		super();
	}

	public Service_Invoice_Card(Integer id, String service_id, Customer_Details customer_Details,
			Service_Type service_Type, Service_Advisor service_Adviser, String service_detail, String tool_kit,
			String spare_wheel, String jack, String jack_handler, String car_perfume, String clock, String cd_player,
			Integer kilometer, Card_Type card_type, Card_Status card_status, Date current_service_date,
			Date service_expire_date, Double total_amount, Date created_date) {
		super();
		this.id = id;
		this.service_id = service_id;
		this.customer_Details = customer_Details;
		this.service_Type = service_Type;
		this.service_Adviser = service_Adviser;
		this.service_detail = service_detail;
		this.tool_kit = tool_kit;
		this.spare_wheel = spare_wheel;
		this.jack = jack;
		this.jack_handler = jack_handler;
		this.car_perfume = car_perfume;
		this.clock = clock;
		this.cd_player = cd_player;
		this.kilometer = kilometer;
		this.card_type = card_type;
		this.card_status = card_status;
		this.current_service_date = current_service_date;
		this.service_expire_date = service_expire_date;
		this.total_amount = total_amount;
		this.created_date = created_date;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "service_id", nullable = false, unique = true)
	public String getService_id() {
		return service_id;
	}

	public void setService_id(String service_id) {
		this.service_id = service_id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_details_id", nullable = false)
	public Customer_Details getCustomer_Details() {
		return customer_Details;
	}

	public void setCustomer_Details(Customer_Details customer_Details) {
		this.customer_Details = customer_Details;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "services_type_id")
	public Service_Type getService_Type() {
		return service_Type;
	}

	public void setService_Type(Service_Type service_Type) {
		this.service_Type = service_Type;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "service_adviser_id")
	public Service_Advisor getService_Adviser() {
		return service_Adviser;
	}

	public void setService_Adviser(Service_Advisor service_Adviser) {
		this.service_Adviser = service_Adviser;
	}

	@Column(name = "service_detail")
	public String getService_detail() {
		return service_detail;
	}

	public void setService_detail(String service_detail) {
		this.service_detail = service_detail;
	}

	@Column(name = "tool_kit")
	public String getTool_kit() {
		return tool_kit;
	}

	public void setTool_kit(String tool_kit) {
		this.tool_kit = tool_kit;
	}

	@Column(name = "spare_wheel")
	public String getSpare_wheel() {
		return spare_wheel;
	}

	public void setSpare_wheel(String spare_wheel) {
		this.spare_wheel = spare_wheel;
	}

	@Column(name = "jack")
	public String getJack() {
		return jack;
	}

	public void setJack(String jack) {
		this.jack = jack;
	}

	@Column(name = "jack_handler")
	public String getJack_handler() {
		return jack_handler;
	}

	public void setJack_handler(String jack_handler) {
		this.jack_handler = jack_handler;
	}

	@Column(name = "car_perfume")
	public String getCar_perfume() {
		return car_perfume;
	}

	public void setCar_perfume(String car_perfume) {
		this.car_perfume = car_perfume;
	}

	@Column(name = "clock")
	public String getClock() {
		return clock;
	}

	public void setClock(String clock) {
		this.clock = clock;
	}

	@Column(name = "cd_player")
	public String getCd_player() {
		return cd_player;
	}

	public void setCd_player(String cd_player) {
		this.cd_player = cd_player;
	}

	@Column(name = "kilometer")
	public Integer getKilometer() {
		return kilometer;
	}

	public void setKilometer(Integer kilometer) {
		this.kilometer = kilometer;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "card_type")
	public Card_Type getCard_type() {
		return card_type;
	}

	public void setCard_type(Card_Type card_type) {
		this.card_type = card_type;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "card_status")
	public Card_Status getCard_status() {
		return card_status;
	}

	public void setCard_status(Card_Status card_status) {
		this.card_status = card_status;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "current_service_date")
	public Date getCurrent_service_date() {
		return current_service_date;
	}

	public void setCurrent_service_date(Date current_service_date) {
		this.current_service_date = current_service_date;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "service_expire_date")
	public Date getService_expire_date() {
		return service_expire_date;
	}

	public void setService_expire_date(Date service_expire_date) {
		this.service_expire_date = service_expire_date;
	}

	@Column(name = "total_amount")
	public Double getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(Double total_amount) {
		this.total_amount = total_amount;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date")
	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

}