package net.amigocraft.pore.implementation.inventory.meta;

import org.bukkit.inventory.meta.BookMeta;

import java.util.List;

// TODO: bridge

public class PoreBookMeta extends PoreItemMeta implements BookMeta {

	@Override
	public boolean hasTitle() {
		return false;
	}

	@Override
	public String getTitle() {
		return null;
	}

	@Override
	public boolean setTitle(String title) {
		return false;
	}

	@Override
	public boolean hasAuthor() {
		return false;
	}

	@Override
	public String getAuthor() {
		return null;
	}

	@Override
	public void setAuthor(String author) {

	}

	@Override
	public boolean hasPages() {
		return false;
	}

	@Override
	public String getPage(int page) {
		return null;
	}

	@Override
	public void setPage(int page, String data) {

	}

	@Override
	public List<String> getPages() {
		return null;
	}

	@Override
	public void setPages(List<String> pages) {

	}

	@Override
	public void setPages(String... pages) {

	}

	@Override
	public void addPage(String... pages) {

	}

	@Override
	public int getPageCount() {
		return 0;
	}

	@Override
	public BookMeta clone() {
		return null;
	}
}
