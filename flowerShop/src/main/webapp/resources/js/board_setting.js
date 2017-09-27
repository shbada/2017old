function setting(mode, idx, title, name, content) {
	f = document.commentform;
	f.mode.value = mode;
	f.idx.value = idx;
	f.commentBtn.value = title;
	f.name.value = name;
	
	while(content.indexOf('<br/>') != -1) {
		content = content.replace("<br/>", "\r\n");
	}
	f.content.value = content;

}