sample
===
* 注释

	select #use("cols")# from TB_USER tbuser where  #use("condition")#

cols
===
	tbuser.ID,tbuser.NAME

updateSample
===
	
	tbuser.ID=#id#,tbuser.NAME=#name#

condition
===

	1 = 1  
	@if(!isEmpty(id)){
	 and tbuser.ID=#id#
	@}
	@if(!isEmpty(name)){
	 and tbuser.NAME=#name#
	@}
	
	