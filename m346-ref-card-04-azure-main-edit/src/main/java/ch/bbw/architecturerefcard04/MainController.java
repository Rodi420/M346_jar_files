package ch.bbw.architecturerefcard04;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Controller
public class MainController {

	private static final Logger LOG = LoggerFactory.getLogger(MainController.class);
	@Autowired
	private FileServiceInterface fileService;

	private File convertMultiPartFileToFile(final MultipartFile multipartFile) {
		final File file = new File(multipartFile.getOriginalFilename());
		try (final FileOutputStream outputStream = new FileOutputStream(file)) {
			outputStream.write(multipartFile.getBytes());
		} catch (IOException e) {
			LOG.error("Error {} occurred while converting the multipart file", e.getLocalizedMessage());
		}
		return file;
	}


	@GetMapping("")
	public String homepage(Model model) {
		model.addAttribute("files", fileService.listFiles());
		return "index";
	}


	@PostMapping("/upload")
	public String uploadFile(@RequestParam("file") MultipartFile multipartFile,
							 RedirectAttributes attributes,
							 Model model) {

		model.addAttribute("files", fileService.listFiles());
		if (!multipartFile.isEmpty()) {
			fileService.uploadFile(convertMultiPartFileToFile(multipartFile));
		}
		return "redirect:";
	}

}
