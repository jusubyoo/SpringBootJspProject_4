const {defineStore} = Pinia

const useBoardListStore = defineStore('board_list', {
	// 변수 잡기
	state:()=>({
		list:[],
		curpage:1,
		totalpage:0,
		
	}),
	// 기능 설정 => methods
	actions:{
		// default 매개변수
		async dataRecv(){
			const res = await axios.get('http://localhost:8080/board/list_vue/', {
				params:{
					page:this.curpage
				}
			})
			this.list=res.data.list
			this.curpage=res.data.curpage
			this.totalpage=res.data.totalpage
		},
		prev(){
			if(this.curpage>1)
				this.curpage=this.curpage-1
			this.dataRecv()
		},
		next(){
			if(this.curpage<this.totalpage)
				this.curpage=this.curpage+1	
			this.dataRecv()
		}
		
	}
	
	
	
})