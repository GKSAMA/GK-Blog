<template>
    <div id="app">
        <img src="./assets/logo.png">
        <div>
            <el-button @click="startHacking">Start</el-button>
        </div>
        <el-button
                :type="success"
                circle
                size="small"
                icon="el-icon-message"
                @click="handleButtonClick"
                :loading="isLoading"
                >
        </el-button>
        <el-input v-model="inputContent"></el-input>

        <el-button @click="additem">
            Additem
        </el-button>
        <ol>
            <!--<transition-group name="fade">-->
            <li v-for="inter in interest">
                {{inter.items}}
            </li>
            <!--</transition-group>-->
        </ol>
        <el-button @click="rmitem">
            Rmitem
        </el-button>
        <!-- 表格部分 -->
        <el-table
                :data="tabledata"
                border
                style="width: 100%">
            <el-table-column
                    prop="id"
                    label="id"
                    width="180">
            </el-table-column>
            <el-table-column
                    prop="name"
                    label="姓名"
                    width="180">
            </el-table-column>
            <el-table-column
                    prop="sex"
                    label="性别"
                    width="180">
            </el-table-column>
            <el-table-column
                    prop="email"
                    label="邮箱">
            </el-table-column>
        </el-table>

    </div>

</template>

<script>

    var t = 5;

    export default {

        data(){
            return{
                isLoading:false,
                buttonType:"success",
                inputContent:"233",
                interest:[
                    {items:"足球"},
                    {items:"篮球"},
                    {items:"排球"},
                    {items:"铅球"},
                    {items:"羽毛球"}
                ],
                tabledata:[
                    {
                        id:1,
                        name:"wangwu",
                        sex:"m",
                        email:"123456789@qq.com"
                    }
                ]
            }
        },
        methods: {
            startHacking() {

                this.$notify({
                    title: 'It works!',
                    type: 'success',
                    message: 'We\'ve laid the ground work for you. It\'s time for you to build something epic!',
                    duration: 5000
                })

                this.isLoading=false;
                this.buttonType="primary";


                this.$http.get("http://localhost:8080/user/listall").then((response)=>{
                    console.log(response.data);
                    this.inputContent = response.data[0].username;
                    var i=0;
                    //this.tabledata.push({ id:2 , name:"zhaoliu" , sex:"m" , email:"888888888@qq.com" });

                    do {
                        this.tabledata.push({
                                                id:response.data[i].id ,
                                                name:response.data[i].username  ,
                                                sex:response.data[i].sex ,
                                                email:response.data[i].email
                                            })
                        i++;
                    }while (i<response.data.length)


                }).catch((error)=>{

                })




            },
            handleButtonClick(){
                // alert("hello");
                this.inputContent="345";
                this.$notify({
                    title:'this is a notify',
                    type:'error',
                    message:'It works!',
                    duration:5000
                })
            },
            additem(){
                t++;
                this.interest.push({items: t +' another'})
            },
            rmitem(){
                if (t>0){
                    this.interest.pop();
                    t--;
                }
            }
        }
    }
</script>

<style>
    #app {
        font-family: Helvetica, sans-serif;
        text-align: center;
    }
</style>
