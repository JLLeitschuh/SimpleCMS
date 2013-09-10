package com.cyganov.simplecms.beans;

import org.richfaces.component.UITree;
import org.richfaces.event.FileUploadEvent;
import org.richfaces.event.TreeSelectionChangeEvent;
import org.richfaces.model.UploadedFile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Tsyhanou Siarhei
 * Date: 05.09.13
 * Time: 12:02
 */
//@Component
//@Scope("session")
@ManagedBean
@SessionScoped
public class FileUploadBean {

	private static final String SRC_PATH = "/img";
	private List<FileSystemNode> srcRoots;
	private FileSystemNode currentSelection = null;

	@PostConstruct
	public void loadFiles(){
		srcRoots = new FileSystemNode(SRC_PATH, FileSystemTypes.DIRECTORY).getDirectories();
	}

	private String getRealPath(String path){
		return FacesContext.getCurrentInstance()
				.getExternalContext().getRealPath(path);
	}

	public synchronized List<FileSystemNode> getSourceRoots() {
		return srcRoots;
	}

	public void selectionChanged(TreeSelectionChangeEvent selectionChangeEvent) {
		List<Object> selection = new ArrayList<Object>(selectionChangeEvent.getNewSelection());
		Object currentSelectionKey = selection.get(0);
		UITree tree = (UITree) selectionChangeEvent.getSource();
		Object storedKey = tree.getRowKey();
		tree.setRowKey(currentSelectionKey);
		currentSelection = (FileSystemNode) tree.getRowData();
		tree.setRowKey(storedKey);
	}

	public FileSystemNode getCurrentSelection() {
		return currentSelection;
	}

	public void setCurrentSelection (FileSystemNode currentSelection) {
		this.currentSelection = currentSelection;
	}

	public void paint(OutputStream stream, Object object) throws IOException {
		if (currentSelection.getType().equals(FileSystemTypes.FILE)){
			String path = getRealPath(currentSelection.getPath());
			byte[] data = Files.readAllBytes(new File(path).toPath());
			stream.write(data);
		}
		stream.close(); //TODO:fix:try/finally
	}

	public void listener(FileUploadEvent event) throws Exception {
		UploadedFile item = event.getUploadedFile();

		String file = getRealPath(currentSelection.getPath() + "/" + item.getName());

		OutputStream output = new FileOutputStream(file);
		output.write(item.getData());
		output.close(); //TODO:fix:try/finally
		loadFiles();
	}

}