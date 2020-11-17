package com.eigenholser.outrider.spdrgld.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
   As Of,Index Level,NAV per Share,Ex-Dividends,Shares Outstanding¬                                                                                                                            
   "Nov 05, 2020","2,457.00",22.85,--,"603,600,000.00"
*/

@Entity
@Table(name = "ishares_slv")
public class IsharesSlv {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private LocalDate date;
	
	@Column(name = "index_level")
	private BigDecimal indexLevel;
	@Column(name = "nav_per_share")
	private BigDecimal navPerShare;
	@Column(name = "ex_dividends")
	private BigDecimal exDividends;
	@Column(name = "shares_outstanding")
	private BigDecimal sharesOutstanding;

	public long getId() {
		return id;
	}

	public LocalDate getDate() {
		return date;
	}

	public BigDecimal getIndexLevel() {
		return indexLevel;
	}

	public BigDecimal getNavPerShare() {
		return navPerShare;
	}

	public BigDecimal getExDividends() {
		return exDividends;
	}

	public BigDecimal getSharesOutstanding() {
		return sharesOutstanding;
	}

	@Override
	public String toString() {
		return "IsharesSlv [id=" + id + ", date=" + date + ", indexLevel=" + indexLevel + ", navPerShare=" + navPerShare
				+ ", exDividends=" + exDividends + ", sharesOutstanding=" + sharesOutstanding + "]";
	}

}
