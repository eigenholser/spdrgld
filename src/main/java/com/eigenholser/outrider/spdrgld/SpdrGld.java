package com.eigenholser.outrider.spdrgld;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/*
   Date, 
   GLD Close, 
   LBMA Gold Price, 
   NAV per GLD in Gold, 
   NAV/share at 10.30 a.m. NYT, 
   Indicative Price of GLD at 4.15 p.m. NYT, 
   Mid point of bid/ask spread at 4.15 p.m. NYT#, 
   Premium/Discount of GLD mid point v Indicative Value of GLD at 4.15 p.m. NYT, 
   Daily Share Volume, 
   Total Net Asset Value Ounces in the Trust as at 4.15 p.m. NYT, 
   Total Net Asset Value Tonnes in the Trust as at 4.15 p.m. NYT, 
   Total Net Asset Value in the Trust¬
   
   [SAMPLE ROW]
   18-Nov-2004, 44.38, $442.00, 100.000000, 44.2, 44.305, $44.37, 0.146%, 5992000, 260000.00, 8.09, 114920000.00
 */

@Entity
@Table(indexes = {@Index(columnList = ("date"))}, uniqueConstraints = {@UniqueConstraint(columnNames = "date")})
public class SpdrGld {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	private BigDecimal gldClosePrice;
	private BigDecimal lbmaGoldPrice;
	private BigDecimal navPerGldInGold;
	private BigDecimal navPerShare;
	private BigDecimal indicativePriceGld;
	private BigDecimal midpointSpread;
	private BigDecimal gldPremium;
	private long dailyShareVolume;
	private BigDecimal navOunces;
	private BigDecimal navTonnes;
	private BigDecimal navUsd;

	public long getId() {
		return id;
	}

	public Date getDate() {
		return date;
	}

	public BigDecimal getGldClosePrice() {
		return gldClosePrice;
	}

	public BigDecimal getLbmaGoldPrice() {
		return lbmaGoldPrice;
	}

	public BigDecimal getNavPerGldInGold() {
		return navPerGldInGold;
	}

	public BigDecimal getNavPerShare() {
		return navPerShare;
	}

	public BigDecimal getIndicativePriceGld() {
		return indicativePriceGld;
	}

	public BigDecimal getMidpointSpread() {
		return midpointSpread;
	}

	public BigDecimal getGldPremium() {
		return gldPremium;
	}

	public long getDailyShareVolume() {
		return dailyShareVolume;
	}

	public BigDecimal getNavOunces() {
		return navOunces;
	}

	public BigDecimal getNavTonnes() {
		return navTonnes;
	}

	public BigDecimal getNavUsd() {
		return navUsd;
	}

	@Override
	public String toString() {
		return "SpdrGld [id=" + id + ", date=" + date + ", gldClosePrice=" + gldClosePrice + ", lbmaGoldPrice="
				+ lbmaGoldPrice + ", navPerGldInGold=" + navPerGldInGold + ", navPerShare=" + navPerShare
				+ ", indicativePriceGld=" + indicativePriceGld + ", midpointSpread=" + midpointSpread + ", gldPremium="
				+ gldPremium + ", dailyShareVolume=" + dailyShareVolume + ", navOunces=" + navOunces + ", navTonnes="
				+ navTonnes + ", navUsd=" + navUsd + "]";
	}

}
