// Make re-rendered forms work. See http://java.net/jira/browse/JAVASERVERFACES_SPEC_PUBLIC-790
(function (cash)
{
  jsf.ajax.addOnEvent(function (e)
  {
    if (e.status === 'complete')
    {
      $("partial-response:first changes:first update[id='javax.faces.ViewState']", e.responseXML).each(function (i, u)
      {
        // update all forms
        $(document.forms).each(function (i, f)
        {
        	addViewState(f,u.firstChild.data);
        });
      });
    }
  });
  function addViewState(form,viewState){
	  var field = $("input[name='javax.faces.ViewState']", form);
      if (field.length == 0)
      {
        field = $("<input type=\"hidden\" name=\"javax.faces.ViewState:0\" />").appendTo(form);
      }
      field.val(viewState);
  }
  jsf.ajax.addOnError(function (data)
		  {
	  		if(typeof stopThinking == 'function'){
	  			stopThinking();
	  		}
	  		console.log('Error: '+data.status+' description - '+data.description);
		  });
})(jQuery);