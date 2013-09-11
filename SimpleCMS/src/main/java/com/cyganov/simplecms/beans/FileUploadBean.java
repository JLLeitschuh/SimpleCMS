package com.cyganov.simplecms.beans;

import org.richfaces.component.UITree;
import org.richfaces.event.FileUploadEvent;
import org.richfaces.event.TreeSelectionChangeEvent;
import org.richfaces.model.UploadedFile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Tsyhanou Siarhei
 * Date: 05.09.13
 * Time: 12:02
 */
@Component
@Scope("session")
public class FileUploadBean {

	private static final String SRC_PATH = "/img";
	private List<FileSystemNode> srcRoots;
	private FileSystemNode currentSelection = null;
    private String newDirectoryName;

	@PostConstruct
	public void init(){
		srcRoots = new FileSystemNode(SRC_PATH, FileSystemTypes.DIRECTORY).getDirectories();
        newDirectoryName = "";
	}

	private String getRealPath(String path){
		return FacesContext.getCurrentInstance()
				.getExternalContext().getRealPath(path);
	}

	public boolean isFile(){
		return currentSelection != null && currentSelection.getType().equals(FileSystemTypes.FILE);
	}

	public void selectionChanged(TreeSelectionChangeEvent selectionChangeEvent) {
		List<Object> selection = new ArrayList<Object>(selectionChangeEvent.getNewSelection());
		Object currentSelectionKey = selection.get(0);
		UITree tree = (UITree) selectionChangeEvent.getSource();
		tree.setRowKey(currentSelectionKey);
		currentSelection = (FileSystemNode) tree.getRowData();
	}

	public void listener(FileUploadEvent event) throws IOException {
		UploadedFile item = event.getUploadedFile();

		String file = getRealPath(currentSelection.getPath() + "/" + item.getName());

		OutputStream output = new FileOutputStream(file);
		try {
			output.write(item.getData());
            init();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			output.close();
		}
	}

    public void copyURL(){
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable transferable = new StringSelection(currentSelection.getPath());
        clipboard.setContents(transferable, null);
    }

    public void createDirectory(){
        String path = getRealPath(currentSelection.getPath() + "/" + newDirectoryName);
        File file = new File(path);
        boolean result = file.mkdirs();
        if (result){
            init();
        }

    }

	public void delete(){
		String filePath = getRealPath(currentSelection.getPath());
		File file = new File(filePath);
        boolean result;
        if (file.isDirectory()){
            result = deleteAllFiles(file);
        } else{
		    result = file.delete();
        }
		if (result){
            init();
		}

	}

    private boolean deleteAllFiles (File file){
        File[] files = file.listFiles();
        if (files != null){
            for (File current : files) {
                if (file.isDirectory()){
                    deleteAllFiles(current);
                } else {
                    file.delete();
                }
            }
        }
        return file.delete();
    }

	public FileSystemNode getCurrentSelection() {
		return currentSelection;
	}

	public void setCurrentSelection (FileSystemNode currentSelection) {
		this.currentSelection = currentSelection;
	}

	public synchronized List<FileSystemNode> getSourceRoots() {
		return srcRoots;
	}

    public String getNewDirectoryName() {
        return newDirectoryName;
    }

    public void setNewDirectoryName(String newDirectoryName) {
        this.newDirectoryName = newDirectoryName;
    }
}