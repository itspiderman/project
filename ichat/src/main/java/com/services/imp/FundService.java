package com.services.imp;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;

import com.services.IFundService;
import com.services.dao.IFundReadDao;
import com.services.dao.IFundWriteDao;
import com.services.dao.imp.FundReadDao;
import com.services.pojo.fund.Fund;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class FundService implements IFundService {
	// injection
	IFundReadDao fundReadDao;
	IFundWriteDao fundWriteDao;

	public void setFundReadDao(IFundReadDao fundDao) {
		this.fundReadDao = fundDao;
	}

	public void setFundWriteDao(IFundWriteDao fundWriteDao) {
		this.fundWriteDao = fundWriteDao;
	}

	// without injection
	public FundService() {
		fundReadDao = new FundReadDao();
	}

	@Override
	public Fund queryFundByFundCode(String fundCode) {
		return fundReadDao.queryByFundCode(fundCode);
	}

	@Override
	public List<Fund> queryFundList() {
		return fundReadDao.queryFundList();
	}

	@Override
	public List<Fund> queryFundList(String sCycleDate) throws Exception {
		return fundReadDao.queryFundList(sCycleDate);
	}

	public HashMap queryFund() {
		HashMap hm = fundReadDao.queryFund();
		return hm;
	}

	@Override
	public int insertFund(Fund fund) {
		return fundWriteDao.insertFund(fund);
	}

	@Override
	public int insertFund(List<Fund> fundList) {
		return fundWriteDao.insertFund(fundList);
	}

	// @Override
	// public int uploadFund(String xlsFileName, String sheetName) {
	// Workbook workbook = null;
	// Sheet sheet = null;
	// // column and row index start from 0;
	// int rows = 0;
	// int row = 1;
	// Date sysDate = null;
	//
	// try {
	// workbook = Workbook.getWorkbook(new File(xlsFileName));
	// sheet = workbook.getSheet(sheetName);
	// // columns=sheet.getColumns();
	// rows = sheet.getRows();
	// while (row < rows) {
	// synchronized (this) {
	// Fund fund = new Fund();
	// sysDate = new Date();
	// fund.setFundCode(sheet.getCell(1, row).getContents().trim());
	// fund.setFundName(sheet.getCell(2, row).getContents());
	// fund.setFundUrl(sheet.getCell(3, row).getContents());
	// fund.setFundTypecode(sheet.getCell(4, row).getContents().charAt(0));
	// fund.setCrtDateTime(new Timestamp(sysDate.getTime()));
	// if (fund.getFundCode() != "") {
	// System.out.println("start row: " + row + "," + fund.getFundCode() +
	// fund.getFundName()
	// + fund.getFundUrl());
	// insertFundThread(fund);
	// } else
	// break;
	// }
	// // After handle 20 rows, make thread sleep for 5 seconds
	// if ((row % 20) == 0) {
	// try {
	// System.out.println("After handle 20 rows, make thread sleep for 5
	// seconds.....");
	// Thread.sleep(8000);
	// } catch (InterruptedException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
	// row++;
	// // for testing
	// if (row > 2)
	// break;
	// }
	// } catch (BiffException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } finally {
	// sheet = null;
	// workbook.close();
	// }
	// // row--;
	// return row;
	// }
	@Override
	public int uploadFund(String xlsFileName, String sheetName) {

		HashMap<?, ?> fundHashMap = null;
		int iReturn = 0;
		Workbook workbook = null;
		// Sheet sheet = null;

		fundHashMap = fundReadDao.queryFund();

		try {
			workbook = Workbook.getWorkbook(new File(xlsFileName));
			Sheet[] sheets = workbook.getSheets();
			for (Sheet st : sheets) {
				iReturn++;
				try {
					if (sheetName == null) {
						System.out.println("start upload sheet" + iReturn + " " + st.getName());
						uploadFundWorkSheet(workbook, st, fundHashMap);
					} else {
						if (sheetName.equals(st.getName())) {
							System.out.println("start upload sheet" + iReturn + " " + st.getName());
							uploadFundWorkSheet(workbook, st, fundHashMap);
						}
					}
				} catch (Exception ex) {
					ex.printStackTrace();
					continue;
				}
			}

			iReturn = 1;

		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// sheet = null;
			workbook.close();
		}
		return iReturn;
	}

	public int uploadFundWorkSheet(Workbook workbook, Sheet sheet, HashMap<?, ?> fundHashMap) throws Exception {
		int rows = 0;
		int row = 1;
		Date sysDate = null;

		rows = sheet.getRows();
		while (row < rows) {
			synchronized (this) {
				Fund fund = new Fund();
				sysDate = new Date();
				fund.setFundCode(sheet.getCell(1, row).getContents().trim());
				fund.setFundName(sheet.getCell(2, row).getContents());
				fund.setFundUrl(sheet.getCell(3, row).getContents());
				fund.setFundTypecode(sheet.getCell(4, row).getContents().charAt(0));
				fund.setCrtDateTime(new Timestamp(sysDate.getTime()));
				if (fund.getFundCode() != "") {
					if (!fundHashMap.containsKey(fund.getFundCode())) {
						System.out.println("start row: " + row + "," + fund.getFundCode() + fund.getFundName()
								+ fund.getFundUrl());
						try {
							insertFundThread(fund);
						} catch (Exception e) {
							System.out.println(sheet.getName() + " expection issue!!!");
							e.printStackTrace();
							continue;
						}
					} else {
						System.out.println("start row: " + row + "," + fund.getFundCode() + " is existing");
					}
				} else
					break;
			}
			row++;
			try {
				if ((row % 200) == 0) {
					System.out.println("200 rows, sleep for 60 seconds"); // Exception
																			// in
																			// thread
																			// "Thread-2940"
																			// java.lang.OutOfMemoryError:
																			// GC
																			// overhead
																			// limit
																			// exceeded
					Thread.sleep(60000);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			// for testing
			// if (row > 200) break;
		}
		return row;
	}

	// 在Service中有可用Sping依敕注入fundWriteDao
	// 在线程 类中 fundWriteDao 用set方法导入,解决Spring不支多线程的缺点。
	public void insertFundThread(Fund fund) {
		FundServiceRunnable fundServiceRunnable = new FundServiceRunnable();
		fundServiceRunnable.setFundWriteDao(fundWriteDao);
		fundServiceRunnable.setFund(fund);
		Thread th = new Thread(fundServiceRunnable);
		th.start();
	}
}