package com.dragueo.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "times")
public class Time {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "time", updatable = false, nullable = false)
	private long time;
	
	@Column(name = "entryLeft")
	private String entryLeft;
	
	@Column(name = "entryRight")
	private String entryRight;
	
	@Column(name = "treespeedLeft")
	private String treespeedLeft;
	
	@Column(name = "treespeedRight")
	private String treespeedRight;
	
	@Column(name = "dialinLeft")
	private String dialinLeft;
	
	@Column(name = "dialinRight")
	private String dialinRight;
	
	@Column(name = "reactionLeft")
	private String reactionLeft;
	
	@Column(name = "reactionRight")
	private String reactionRight;
	
	@Column(name = "ft60Left")
	private String ft60Left;
	
	@Column(name = "ft60Right")
	private String ft60Right;
	
	@Column(name = "ft330Left")
	private String ft330Left;
	
	@Column(name = "ft330Right")
	private String ft330Right;
	
	@Column(name = "ft660Left")
	private String ft660Left;
	
	@Column(name = "ft660Right")
	private String ft660Right;
	
	@Column(name = "mph1Left")
	private String mph1Left;
	
	@Column(name = "mph1Right")
	private String mph1Right;
	
	@Column(name = "ft1320Left")
	private String ft1320Left;
	
	@Column(name = "ft1320Right")
	private String ft1320Right;
	
	@Column(name = "mphLeft")
	private String mphLeft;
	
	@Column(name = "mphRight")
	private String mphRight;
	
	@Column(name = "firstLeft")
	private String firstLeft;
	
	@Column(name = "firstRight")
	private String firstRight;
	
	@Column(name = "statusLeft")
	private String statusLeft;
	
	@Column(name = "statusRight")
	private String statusRight;
	
	@Column(name = "fecha")
	private String fecha;
	
	@Column(name = "driverLeft")
	private String driverLeft;
	
	@Column(name = "driverRight")
	private String driverRight;
	
	@Column(name = "countryLeft")
	private String countryLeft;
	
	@Column(name = "countryRight")
	private String countryRight;
	
	@Column(name = "carLeft")
	private String carLeft;
	
	@Column(name = "carRight")
	private String carRight;
	
	public Time() {}
	
	public Time(long time, String entryLeft, String entryRight, String treespeedLeft, String treespeedRight,
			String dialinLeft, String dialinRight, String reactionLeft, String reactionRight, String ft60Left,
			String ft60Right, String ft330Left, String ft330Right, String ft660Left, String ft660Right, String mph1Left,
			String mph1Right, String ft1320Left, String ft1320Right, String mphLeft, String mphRight, String firstLeft,
			String firstRight, String statusLeft, String statusRight, String fecha, String driverLeft,
			String driverRight, String countryLeft, String countryRight, String carLeft, String carRight) {
		
		this.time = time;
		this.entryLeft = entryLeft;
		this.entryRight = entryRight;
		this.treespeedLeft = treespeedLeft;
		this.treespeedRight = treespeedRight;
		this.dialinLeft = dialinLeft;
		this.dialinRight = dialinRight;
		this.reactionLeft = reactionLeft;
		this.reactionRight = reactionRight;
		this.ft60Left = ft60Left;
		this.ft60Right = ft60Right;
		this.ft330Left = ft330Left;
		this.ft330Right = ft330Right;
		this.ft660Left = ft660Left;
		this.ft660Right = ft660Right;
		this.mph1Left = mph1Left;
		this.mph1Right = mph1Right;
		this.ft1320Left = ft1320Left;
		this.ft1320Right = ft1320Right;
		this.mphLeft = mphLeft;
		this.mphRight = mphRight;
		this.firstLeft = firstLeft;
		this.firstRight = firstRight;
		this.statusLeft = statusLeft;
		this.statusRight = statusRight;
		this.fecha = fecha;
		this.driverLeft = driverLeft;
		this.driverRight = driverRight;
		this.countryLeft = countryLeft;
		this.countryRight = countryRight;
		this.carLeft = carLeft;
		this.carRight = carRight;
	}

	
	public Time(String entryLeft, String entryRight, String treespeedLeft, String treespeedRight, String dialinLeft,
			String dialinRight, String reactionLeft, String reactionRight, String ft60Left, String ft60Right,
			String ft330Left, String ft330Right, String ft660Left, String ft660Right, String mph1Left, String mph1Right,
			String ft1320Left, String ft1320Right, String mphLeft, String mphRight, String firstLeft, String firstRight,
			String statusLeft, String statusRight, String fecha) {
		super();
		this.entryLeft = entryLeft;
		this.entryRight = entryRight;
		this.treespeedLeft = treespeedLeft;
		this.treespeedRight = treespeedRight;
		this.dialinLeft = dialinLeft;
		this.dialinRight = dialinRight;
		this.reactionLeft = reactionLeft;
		this.reactionRight = reactionRight;
		this.ft60Left = ft60Left;
		this.ft60Right = ft60Right;
		this.ft330Left = ft330Left;
		this.ft330Right = ft330Right;
		this.ft660Left = ft660Left;
		this.ft660Right = ft660Right;
		this.mph1Left = mph1Left;
		this.mph1Right = mph1Right;
		this.ft1320Left = ft1320Left;
		this.ft1320Right = ft1320Right;
		this.mphLeft = mphLeft;
		this.mphRight = mphRight;
		this.firstLeft = firstLeft;
		this.firstRight = firstRight;
		this.statusLeft = statusLeft;
		this.statusRight = statusRight;
		this.fecha = fecha;
	}
	
	public Time(String entryLeft, String entryRight, String treespeedLeft, String treespeedRight, String dialinLeft,
			String dialinRight, String reactionLeft, String reactionRight, String ft60Left, String ft60Right,
			String ft330Left, String ft330Right, String ft660Left, String ft660Right, String mph1Left, String mph1Right,
			String ft1320Left, String ft1320Right, String mphLeft, String mphRight, String firstLeft, String firstRight,
			String statusLeft, String statusRight, String fecha, String driverLeft, String driverRight,
			String countryLeft, String countryRight, String carLeft, String carRight) {
		super();
		this.entryLeft = entryLeft;
		this.entryRight = entryRight;
		this.treespeedLeft = treespeedLeft;
		this.treespeedRight = treespeedRight;
		this.dialinLeft = dialinLeft;
		this.dialinRight = dialinRight;
		this.reactionLeft = reactionLeft;
		this.reactionRight = reactionRight;
		this.ft60Left = ft60Left;
		this.ft60Right = ft60Right;
		this.ft330Left = ft330Left;
		this.ft330Right = ft330Right;
		this.ft660Left = ft660Left;
		this.ft660Right = ft660Right;
		this.mph1Left = mph1Left;
		this.mph1Right = mph1Right;
		this.ft1320Left = ft1320Left;
		this.ft1320Right = ft1320Right;
		this.mphLeft = mphLeft;
		this.mphRight = mphRight;
		this.firstLeft = firstLeft;
		this.firstRight = firstRight;
		this.statusLeft = statusLeft;
		this.statusRight = statusRight;
		this.fecha = fecha;
		this.driverLeft = driverLeft;
		this.driverRight = driverRight;
		this.countryLeft = countryLeft;
		this.countryRight = countryRight;
		this.carLeft = carLeft;
		this.carRight = carRight;
	}

	public long getTime() {
		return time;
	}
	
	public void setTime(long time) {
		this.time = time;
	}
	
	public String getEntryLeft() {
		return entryLeft;
	}
	
	public void setEntryLeft(String entryLeft) {
		this.entryLeft = entryLeft;
	}
	
	public String getEntryRight() {
		return entryRight;
	}
	
	public void setEntryRight(String entryRight) {
		this.entryRight = entryRight;
	}
	
	public String getTreespeedLeft() {
		return treespeedLeft;
	}
	
	public void setTreespeedLeft(String treespeedLeft) {
		this.treespeedLeft = treespeedLeft;
	}
	
	public String getTreespeedRight() {
		return treespeedRight;
	}
	
	public void setTreespeedRight(String treespeedRight) {
		this.treespeedRight = treespeedRight;
	}
	
	public String getDialinLeft() {
		return dialinLeft;
	}
	
	public void setDialinLeft(String dialinLeft) {
		this.dialinLeft = dialinLeft;
	}
	
	public String getDialinRight() {
		return dialinRight;
	}
	
	public void setDialinRight(String dialinRight) {
		this.dialinRight = dialinRight;
	}
	
	public String getReactionLeft() {
		return reactionLeft;
	}
	
	public void setReactionLeft(String reactionLeft) {
		this.reactionLeft = reactionLeft;
	}
	
	public String getReactionRight() {
		return reactionRight;
	}
	
	public void setReactionRight(String reactionRight) {
		this.reactionRight = reactionRight;
	}
	
	public String getFt60Left() {
		return ft60Left;
	}
	
	public void setFt60Left(String ft60Left) {
		this.ft60Left = ft60Left;
	}
	
	public String getFt60Right() {
		return ft60Right;
	}
	
	public void setFt60Right(String ft60Right) {
		this.ft60Right = ft60Right;
	}
	
	public String getFt330Left() {
		return ft330Left;
	}
	
	public void setFt330Left(String ft330Left) {
		this.ft330Left = ft330Left;
	}
	
	public String getFt330Right() {
		return ft330Right;
	}
	
	public void setFt330Right(String ft330Right) {
		this.ft330Right = ft330Right;
	}
	
	public String getFt660Left() {
		return ft660Left;
	}
	
	public void setFt660Left(String ft660Left) {
		this.ft660Left = ft660Left;
	}
	
	public String getFt660Right() {
		return ft660Right;
	}
	
	public void setFt660Right(String ft660Right) {
		this.ft660Right = ft660Right;
	}
	
	public String getMph1Left() {
		return mph1Left;
	}
	
	public void setMph1Left(String mph1Left) {
		this.mph1Left = mph1Left;
	}
	
	public String getMph1Right() {
		return mph1Right;
	}
	
	public void setMph1Right(String mph1Right) {
		this.mph1Right = mph1Right;
	}
	
	public String getFt1320Left() {
		return ft1320Left;
	}
	
	public void setFt1320Left(String ft1320Left) {
		this.ft1320Left = ft1320Left;
	}
	
	public String getFt1320Right() {
		return ft1320Right;
	}
	
	public void setFt1320Right(String ft1320Right) {
		this.ft1320Right = ft1320Right;
	}
	
	public String getMphLeft() {
		return mphLeft;
	}
	
	public void setMphLeft(String mphLeft) {
		this.mphLeft = mphLeft;
	}
	
	public String getMphRight() {
		return mphRight;
	}
	
	public void setMphRight(String mphRight) {
		this.mphRight = mphRight;
	}
	
	public String getFirstLeft() {
		return firstLeft;
	}
	
	public void setFirstLeft(String firstLeft) {
		this.firstLeft = firstLeft;
	}
	
	public String getFirstRight() {
		return firstRight;
	}
	
	public void setFirstRight(String firstRight) {
		this.firstRight = firstRight;
	}
	
	public String getStatusLeft() {
		return statusLeft;
	}
	
	public void setStatusLeft(String statusLeft) {
		this.statusLeft = statusLeft;
	}
	
	public String getStatusRight() {
		return statusRight;
	}
	
	public void setStatusRight(String statusRight) {
		this.statusRight = statusRight;
	}
	
	public String getFecha() {
		return fecha;
	}
	
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public String getDriverLeft() {
		return driverLeft;
	}
	
	public void setDriverLeft(String driverLeft) {
		this.driverLeft = driverLeft;
	}
	
	public String getDriverRight() {
		return driverRight;
	}
	
	public void setDriverRight(String driverRight) {
		this.driverRight = driverRight;
	}
	
	public String getCountryLeft() {
		return countryLeft;
	}
	
	public void setCountryLeft(String countryLeft) {
		this.countryLeft = countryLeft;
	}
	
	public String getCountryRight() {
		return countryRight;
	}
	
	public void setCountryRight(String countryRight) {
		this.countryRight = countryRight;
	}
	
	public String getCarLeft() {
		return carLeft;
	}
	
	public void setCarLeft(String carLeft) {
		this.carLeft = carLeft;
	}
	
	public String getCarRight() {
		return carRight;
	}
	
	public void setCarRight(String carRight) {
		this.carRight = carRight;
	}

	@Override
	public String toString() {
		return "Time [time=" + time + ", entryLeft=" + entryLeft + ", entryRight=" + entryRight + ", treespeedLeft="
				+ treespeedLeft + ", treespeedRight=" + treespeedRight + ", dialinLeft=" + dialinLeft + ", dialinRight="
				+ dialinRight + ", reactionLeft=" + reactionLeft + ", reactionRight=" + reactionRight + ", ft60Left="
				+ ft60Left + ", ft60Right=" + ft60Right + ", ft330Left=" + ft330Left + ", ft330Right=" + ft330Right
				+ ", ft660Left=" + ft660Left + ", ft660Right=" + ft660Right + ", mph1Left=" + mph1Left + ", mph1Right="
				+ mph1Right + ", ft1320Left=" + ft1320Left + ", ft1320Right=" + ft1320Right + ", mphLeft=" + mphLeft
				+ ", mphRight=" + mphRight + ", firstLeft=" + firstLeft + ", firstRight=" + firstRight + ", statusLeft="
				+ statusLeft + ", statusRight=" + statusRight + ", fecha=" + fecha + ", driverLeft=" + driverLeft
				+ ", driverRight=" + driverRight + ", countryLeft=" + countryLeft + ", countryRight=" + countryRight
				+ ", carLeft=" + carLeft + ", carRight=" + carRight + "]";
	}
	
	
}
