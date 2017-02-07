package com.ionic.in.criminalintent;

import java.util.Date;
import java.util.UUID;

public class Crime
{
  private UUID mId;
  private String mTitle;
  private Date mDate;
  private boolean mSolved;

  public Crime()
  {
    mId = UUID.randomUUID();
    mDate = new Date();
  }

  public UUID getId() {
    return mId;
  }

  public void setId(UUID mId) {
    this.mId = mId;
  }

  public String getTitle() {
    return mTitle;
  }

  public void setTitle(String mTitle) {
    this.mTitle = mTitle;
  }

  public Date getDate() {
    return mDate;
  }

  public void setDate(Date mDate) {
    this.mDate = mDate;
  }

  public boolean isSolved() {
    return mSolved;
  }

  public void setSolved(boolean mSolved) {
    this.mSolved = mSolved;
  }
}
