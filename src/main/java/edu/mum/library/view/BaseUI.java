package edu.mum.library.view;

import org.springframework.beans.factory.annotation.Autowired;

import edu.mum.library.LibraryApplication;

public abstract class BaseUI {
	@Autowired
	protected LibraryApplication application;
}
