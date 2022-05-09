package com.hof.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hof.domain.Category;
import com.hof.domain.Giftfor;
import com.hof.domain.Occasion;
import com.hof.domain.Product;
import com.hof.domain.Supplier;
import com.hof.domain.dto.CommonResponseDto;
import com.hof.services.ProductService;
import com.hof.services.SupplierService;



@RestController
public class AdminController {

	@Autowired
	SupplierService supService;

	@Autowired
	ProductService proService;

	private String fileLocation;

	@GetMapping("/supplier")
	public String getSupplierData() {

		return "successfull";
	}

	// getting all products from supplier sheet
	@GetMapping("/getlist")
	public List<Supplier> getList() {
		List<Supplier> slist = supService.getList();
		List<Supplier> approvedList = new ArrayList();
		for (Supplier supplier : slist) {
			if (!supplier.isApproved()) {
				approvedList.add(supplier);
			}
		}
		return approvedList;

	}

	@PostMapping(value = "/uploadExcelFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public String uploadFile(Model model, @RequestParam("file") MultipartFile file) throws IOException {
		InputStream in = file.getInputStream();
		File currDir = new File(".");
		String path = currDir.getAbsolutePath();
		fileLocation = path.substring(0, path.length() - 1) + file.getOriginalFilename();
		FileOutputStream f = new FileOutputStream(fileLocation);

		// validation file is xlxs or not
		if (fileLocation != null) {
			if (fileLocation.endsWith(".xlsx") || fileLocation.endsWith(".xls")) {
				System.out.println(" valid excel file!");
				int ch = 0;
				while ((ch = in.read()) != -1) {
					f.write(ch);
				}
				f.flush();
				f.close();
				System.out.println("File: " + file.getOriginalFilename() + " has been uploaded successfully!    "
						+ " filelocation: " + fileLocation);

				// -------------------------------------------//
				String excelFilePath = fileLocation;

				try {
					long start = System.currentTimeMillis();
					List<Supplier> supList = new ArrayList();

					FileInputStream inputStream = new FileInputStream(excelFilePath);
					Workbook workbook = new XSSFWorkbook(inputStream);
					Sheet firstSheet = (Sheet) workbook.getSheetAt(0);
					Iterator<Row> rowIterator = firstSheet.iterator();
					rowIterator.next(); // skip the header row

					while (rowIterator.hasNext()) {
						Row nextRow = rowIterator.next();
						Iterator<Cell> cellIterator = nextRow.cellIterator();
						Supplier s = new Supplier();
						while (cellIterator.hasNext()) {

							Cell nextCell = cellIterator.next();
							int columnIndex = nextCell.getColumnIndex();
							switch (columnIndex) {
							case 0:
								// String giftname = nextCell.getStringCellValue();
								s.setProductName(nextCell.getStringCellValue());
								break;

							case 1:
								// String description = nextCell.getStringCellValue();
								s.setDescription(nextCell.getStringCellValue());

								break;
							case 2:
								String catagory = nextCell.getStringCellValue();
								s.setCategoryId(catagory);

								break;
							case 3:
								double price = nextCell.getNumericCellValue();
								s.setPrice((float) price);

								break;

							case 4:
								// String ImagePath = nextCell.getStringCellValue();
								s.setImagePath(nextCell.getStringCellValue());
								break;

							case 5:
								int quantity = (int) nextCell.getNumericCellValue();
								s.setQuantity(quantity);

								break;
							case 6:
								String gift_for = nextCell.getStringCellValue();
								// System.out.println("gift_for: "+ gift_for);
								s.setGiftId(gift_for);

								break;
							case 7:
								String occasion = nextCell.getStringCellValue();
								// System.out.println("occasion : " + occasion);
								s.setOccasionId(occasion);
								break;

							}// end of switch case
							s.setApproved(false);

						} // end of inner while loop
						supList.add(s);

						// System.out.println("Data Added
						// SuccessFully......"+supService.addSupplierFileData(s));

					} // end of outer while loop
					for (Supplier s1 : supList) {
						System.out.println(s1.toString());
					}
					System.out.println("Data Added SuccessFully......" + supService.addSupplierFileData(supList));

					workbook.close();

					long end = System.currentTimeMillis();
					System.out.printf("Import done in %d ms\n", (end - start));

				} catch (IOException ex1) {
					System.out.println("Error reading file");
					ex1.printStackTrace();
				}

			} else {
				System.out.println("Not a valid excel file!");
				return "Not a valid excel file!";
			}
		} else {
			System.out.println("File missing! Please upload an excel file.");
			return "File missing! Please upload an excel file.";
		}

		return "excel";
	}

	// approveing supplier list

	@PostMapping("/getSidArray")
	public String getSidArray(@RequestBody String sid) {

		List<Integer> numlist = new ArrayList();
		List<Product> prodlist = new ArrayList();
		List<Supplier> approvedList = new ArrayList();
		System.out.println("sid: " + sid);
		String strNew = sid.substring(1, sid.length() - 1);

		String array1[] = strNew.split(",");

		for (String temp : array1) {
			System.out.println(temp);
			numlist.add(Integer.parseInt(temp));
		}
		for (int num : numlist) {
			// suplist.add(supService.getSingleSupplier(num));
			Supplier s = supService.getSingleSupplier(num);

			// appproving products in suppplier
			s.setApproved(true);
			approvedList.add(s);

			Product p = new Product();

			System.out.println("supllier : " + supService.getSingleSupplier(num).toString());
			p.setProductId(0);
			System.out.println("==========>" + s.getProductName());
			p.setProductName(s.getProductName());
			p.setPrice((int) s.getPrice());
			p.setQuantity(s.getQuantity());
			p.setDescription(s.getDescription());
			p.setImagePath(s.getImagePath());
			p.setVisibility(true);

			Category c = new Category();
			if (s.getCategoryId().equals("Gourmet")) {
				System.out.println(" Compare ==========>" + s.getCategoryId());

				c.setCategoryId(1);
				c.setCategoryName(s.getCategoryId());
				System.out.println("gourmet is set");

			} else if (s.getCategoryId().equals("Cakes")) {
				c.setCategoryId(2);
				c.setCategoryName(s.getCategoryId());
				System.out.println("Cakes is set");
			} else if (s.getCategoryId().equals("Toys")) {
				c.setCategoryId(3);
				c.setCategoryName(s.getCategoryId());
				System.out.println("ToysAndGames is set");
			} else if (s.getCategoryId().equals("Flowers")) {
				c.setCategoryId(4);
				c.setCategoryName(s.getCategoryId());
				System.out.println("Flowers is set");
			} else if (s.getCategoryId().equals("Fashion")) {
				c.setCategoryId(5);
				c.setCategoryName(s.getCategoryId());
				System.out.println("Fashion is set");
			} else if (s.getCategoryId().equals("Personalized")) {
				c.setCategoryId(6);
				c.setCategoryName(s.getCategoryId());
				System.out.println("Personalized is set");
			} else if (s.getCategoryId().equals("Games")) {
				c.setCategoryId(6);
				c.setCategoryName(s.getCategoryId());
				System.out.println("Games is set");
			} else if (s.getCategoryId().equals("Home")) {
				c.setCategoryId(7);
				c.setCategoryName(s.getCategoryId());
				System.out.println("Home is set");
			}

			else {
				System.out.println("Error: not set category..");
			}
			p.setCategory(c);

			// giftfor
			Giftfor gf = new Giftfor();
			if (s.getGiftId().equals("Men")) {
				gf.setGiftForId(1);
				gf.setGiftForWhom(s.getGiftId());
			}

			else if (s.getGiftId().equals("Women")) {
				gf.setGiftForId(2);
				gf.setGiftForWhom(s.getGiftId());

			} else if (s.getGiftId().equals("Infants")) {
				gf.setGiftForId(3);
				gf.setGiftForWhom(s.getGiftId());

			} else if (s.getGiftId().equals("Kids")) {
				gf.setGiftForId(4);
				gf.setGiftForWhom(s.getGiftId());

			} else if (s.getGiftId().equals("Couples")) {
				gf.setGiftForId(5);
				gf.setGiftForWhom(s.getGiftId());

			} else if (s.getGiftId().equals("Generalized")) {
				gf.setGiftForId(6);
				gf.setGiftForWhom(s.getGiftId());

			} else {
				System.out.println("Error: not set giftfor ...");
			}
			p.setGiftfor(gf);
			// occasion

			Occasion o = new Occasion();
			if (s.getOccasionId().equals("Birthday")) {
				o.setOccasionId(1);
				o.setOccasionName(s.getOccasionId());
			}

			else if (s.getOccasionId().equals("Anniversary")) {
				o.setOccasionId(2);
				o.setOccasionName(s.getOccasionId());

			} else if (s.getOccasionId().equals("Festival")) {
				o.setOccasionId(3);
				o.setOccasionName(s.getOccasionId());

			} else if (s.getOccasionId().equals("HouseWarming")) {
				o.setOccasionId(4);
				o.setOccasionName(s.getOccasionId());

			} else if (s.getOccasionId().equals("AllOccasions")) {
				o.setOccasionId(5);
				o.setOccasionName(s.getOccasionId());

			}

			else {
				System.out.println("Error: not set Occasion ...");
			}

			p.setOccasion(o);

			System.out.println(p.toString());
			prodlist.add(p);

		} // end of forloop

		supService.updateApprovedList(approvedList);

		CommonResponseDto commonResponseDto = proService.addProduct(prodlist);
		return commonResponseDto.getResponseMessage();

	}

	@DeleteMapping("/products/{product_id}")
	public String DeleteGift(int productId) {
		Product p = new Product();
		boolean flag = p.isVisibility();
		if (flag) {
			p.setVisibility(false);
			return "set visibility false";
		} else {
			return " set visible true ";
		}

	}

}
