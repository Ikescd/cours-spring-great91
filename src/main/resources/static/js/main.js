window.onload = function(){
	let csrfElement = $("#_csrf");
	let token = "";
	if (csrfElement) {
		token = csrfElement.data("token");
	}
	let pathElement = $("#contextPath");
	let contextPath = pathElement.data("path");
	$(".deleteBtn").click(function(event){
		let prodId = $(this).data("id");
		$.ajax({
			  type: "POST",
			  url: contextPath+"/admin/produit/delete/"+prodId,
			  //data: {_csrf:token},
			  success: function(data){
					window.location.href = contextPath+"/produit/list";
				}
			});
	});
	$(".quantiteInput").change(function(event){
		let prodId = $(this).data("id");
		let quantite = $(this).val();
		$.ajax({
			  type: "POST",
			  url: contextPath+"/panier/update?id="+prodId,
			  data: {quantite: quantite, _csrf:token},
			  success: function(data){
				  if (data.hasOwnProperty("failure")) {
					  event.target.value = data.qte;
				  }
				  else{
					  let idSpan = "#total"+prodId;
					  $(idSpan).html(data.prixTotal);
				  }
				}
			});
	});
	$(".panierDeleteBtn").click(function(event){
		let prodId = $(this).data("id");
		$.ajax({
			  type: "POST",
			  url: contextPath+"/panier/delete/"+prodId,
			  data: {_csrf:token},
			  success: function(data){
					window.location.href = contextPath+"/panier/list";
				}
			});
	});
}