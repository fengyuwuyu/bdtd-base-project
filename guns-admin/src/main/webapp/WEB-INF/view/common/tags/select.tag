@/*
    select标签中各个参数的说明:
    name : select的名称
    id : select的id
    underline : 是否带分割线
    itemList : 下拉列表需要显示的数据
@*/
<div class="form-group">
    <label class="col-sm-3 control-label">${name}</label>
    <div class="col-sm-9">
        <select class="form-control" id="${id}" name="${id}"
        @if(isNotEmpty(disabled)){
                    disabled="${disabled}"
               @}
        >
        	@if (isNotEmpty(itemList)) { 
        		@for (item in itemList) {
        		<option value="${item.num}"
        			@if (isNotEmpty(itemValue) && parseInt(itemValue) == item.num) {
        				selected="selected"
        			@}
        		>${item.name}</option>
        		@}
        	@} 
        	@if (isNotEmpty(tagBody)) {
           		${tagBody!}
        	@} 
        </select>
        @if(isNotEmpty(hidden)){
            <input class="form-control" type="hidden" id="${hidden}" value="${hiddenValue!}">
        @}
    </div>
</div>
@if(isNotEmpty(underline) && underline == 'true'){
    <div class="hr-line-dashed"></div>
@}


