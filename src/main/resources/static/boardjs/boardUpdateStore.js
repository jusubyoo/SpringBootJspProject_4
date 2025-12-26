const {defineStore} = Pinia

const useBoardUpdateStore=defineStore('board_update',{
	// jsp 에서 store 로 연결
	state:()=>({
		name:'',
		subject:'',
		content:'',
		pwd:'',
		msg:'',
		no:0,
		vo:{}
	}),
	// 서버와 연동
	/*
		SELECT : Get
		DELETE : Delete
		PUT : 
	*/
	actions:{
		async boardUpdate({nameRef,subRef,contRef,pwdRef}){
			if(this.name==='')
			{
				nameRef.focus()
				return
			}
			if(this.subject==='')
			{
				subRef.focus()
				return
			}
			if(this.content==='')
			{
				contRef.focus()
				return
			}
			if(this.pwd==='')
			{
				pwdRef.focus()
				return
			}
			// => JSP
			const res=await axios.post('http://localhost:8080/board/update_ok_vue/',{
				name:this.name,
				subject:this.subject,
				content:this.content,
				pwd:this.pwd,
				no:this.no
			})
			
			if(res.data.msg==='yes')
			{
				location.href='/board/detail?no='+this.no
			}
			else
			{
				alert('수정에 실패했습니다.')
				this.pwd=''
				pwdRef.focus()
			}
		},
		// detail 
		async boardUpdateData(no){
			this.no=no
			const res=await axios.get('http://localhost:8080/board/update_vue/',{
				params:{
					no:no
				}
			})
			this.vo=res.data
			this.name=res.data.name
			this.subject=res.data.subject
			this.content=res.data.content
			this.no=res.data.no
		}
	}
})